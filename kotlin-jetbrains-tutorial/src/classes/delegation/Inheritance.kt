package classes.delegation

interface IPrinter {

    fun print(value: String)

    fun remotePrint(value: String)

}

class PrinterImpl : IPrinter {

    override fun print(value: String) {
        println("Printing value: $value")
    }

    override fun remotePrint(value: String) {
        println("Printing value - $value remotely ")
    }

}

// If a class implements a member of an interface implemented by a delegate,
// then the priority is given to an implemented class member, not to a delegate
class SmartGenerationPrinter(iPrinter: IPrinter): IPrinter by iPrinter {

    override fun remotePrint(value: String) {
        println("Printing value - $value remotely and leading report")
    }

}

fun main() {
    val iPrinter = PrinterImpl()
    iPrinter.print("Hello world")
    iPrinter.remotePrint("Hello Kotlin")

    val smartPrinter = SmartGenerationPrinter(iPrinter)
    smartPrinter.remotePrint("Hello Kotlin")
}