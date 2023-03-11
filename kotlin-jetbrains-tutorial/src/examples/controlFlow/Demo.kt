package examples.controlFlow

class Car(private val name: String) {
    override fun toString(): String {
        return "Car{name: $name}"
    }
}

// When statement
fun caseStatement(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println(1)
        is Long -> println(true)
        else -> println("Unknown")
    }
}

// When statement
fun caseExpression(obj: Any): Any {
    return when (obj) {
        1 -> "One"
        "Hello" -> 1
        is Long -> true
        is Car -> obj
        else -> "Unknown"
    }
}

fun main() {
    // When Statement
    println("---------\nWhen statements")
    caseStatement("Hello")
    caseStatement(1)
    caseStatement(0L)
    caseStatement(Car("Ferari"))
    caseStatement("hello")

    // When expression
    println("---------\nWhen expressions")
    println(caseExpression("Hello"))
    println(caseExpression(1))
    println(caseExpression(Car("Ferrari")))
    println(caseExpression(0L))
}