package classes.delegation

interface Printer {

    fun print()

}

class SmartPrinter(private val version: String): Printer {

    override fun print() {
        println("Smart Printer with version $version is printing")
    }

}

// This is called delegation pattern.
// Class implements an interface,
// but instead of implementing its members
class PrinterDelegator(printer: Printer): Printer by printer


fun main() {

    val printer = SmartPrinter("Cosmic ray: 1.0")
    PrinterDelegator(printer).print()

}