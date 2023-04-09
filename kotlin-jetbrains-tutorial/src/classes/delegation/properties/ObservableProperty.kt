package classes.delegation.properties

import kotlin.properties.Delegates

class User {

    var username: String by Delegates.observable("123user") { property, oldValue, newValue ->
        println("Property: ${property.name}, OldValue: $oldValue to new value: $newValue")
    }

    override fun toString(): String {
        return "{User: $username}"
    }

}

fun main() {
    val user = User()
    println(user)
    user.username = "baggio"
    println(user)
}