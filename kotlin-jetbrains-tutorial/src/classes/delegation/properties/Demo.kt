package classes.delegation.properties

import kotlin.reflect.KProperty
import kotlin.reflect.jvm.jvmName

class Example(val name: String) {

    var value: Int by PropertyDelegation(0)

    override fun toString(): String {
        return "Example{name: $name}"
    }
}

// To provide a delegate for a property,
// you need to provide an object that implements two methods:
// operator fun <T> setValue(example: Any, property: KProperty<*>, newValue: T) -> for `var` properties
//operator fun <T> getValue(example: Any, property: KProperty<*>): Int -> for both `val` and `var` properties
class PropertyDelegation(private var delegatedValue: Int) {
    operator fun getValue(example: Example, property: KProperty<*>): Int {
        println("Getting of property: ${property.name}. Value retrieval has been delegated to class: $this")
        return delegatedValue
    }

    operator fun setValue(example: Example, property: KProperty<*>, newValue: Int) {
        println("Setting value $newValue to property: ${property.name} of class ${example::class.simpleName}")
        delegatedValue = newValue
    }

    override fun toString(): String {
        return "PropertyDelegation"
    }

}

fun main() {
    val example = Example("car")
    println(example.value)
    example.value = 1231
    println(example.value)
}