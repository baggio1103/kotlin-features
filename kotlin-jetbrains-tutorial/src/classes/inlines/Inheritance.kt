package classes.inlines

interface Printable {

    fun print()

}

@JvmInline
value class SmartPrinter(private val version: String): Printable {

    override fun print() {
        println("SmartPrinter version: $version is printing")
    }

}

// Inline classes are always final, they cannot participate in a class hierarchy
// They can extend only interfaces
fun main() {
    val printer = SmartPrinter("1.0")
    printer.print()
}