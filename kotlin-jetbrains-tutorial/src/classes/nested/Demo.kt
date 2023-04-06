package classes.nested

class Outer {

    private val value: Int = 1

    class Nested {

        fun printInfo() {
            println("This is a nested class inside Outer class")
        }

    }

}

// Nested class cannot see and have access to field of outer class
//fun printInfo() {
//    println("This is a nested class inside Outer class. Outer class field value: $value")
//} This results in compile time error!

fun main() {
    // To init a nested class, we reference the class via an outer class name
    val nested = Outer.Nested()
    nested.printInfo()
}