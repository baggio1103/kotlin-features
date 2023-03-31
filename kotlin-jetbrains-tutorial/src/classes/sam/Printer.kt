package classes.sam

interface Printer {

    fun print()

}

// Before functional interfaces in Kotlin,
// there was another way to init lambda expression from interface
// Declare a function that accepts a function as argument and has a return type of Interface
// In the body, implement interface using `object` and call the lambda from the argument
fun Printer(block: () -> Unit): Printer = object : Printer {
    override fun print() {
        block()
    }
}

fun interface AdvancedInterface {
    fun print()
}

fun main() {
    val printer = Printer {
        println("Printing...")
    }
    printer.print()

    val advancedInterface = AdvancedInterface {
        println("Advanced printing...")
    }
    advancedInterface.print()
}