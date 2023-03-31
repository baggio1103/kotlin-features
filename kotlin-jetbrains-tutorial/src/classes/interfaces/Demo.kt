package classes.interfaces

// Properties in Interfaces
interface IRobot {

    // abstract, it should be overridden in subclasses
    var value: String

    // a property with accessor
    val name: String
        get() = "Jarvis"

    fun printInfo() {
        println("Name: $name, value: $value")
    }

}

class Jarvis(override var value: String) : IRobot {

}

fun main() {
    val jarvis = Jarvis("Assistant")
    println(jarvis.name)
    println(jarvis.value)
    jarvis.printInfo()
}