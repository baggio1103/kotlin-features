package classes.`object`

interface Reportable<T> {

    fun reportLog(log: T)

}

class Logging {

    // Only one instance of companion
    // object is allowed inside a class

    companion object Logger: Reportable<String> {
        fun log() {
            println("Logging")
        }

        override fun reportLog(log: String) {
            println("Sending logs to a remote server - [$log]")
        }

    }

    object Printer {
        fun print() {
            println("Printing...")
        }
    }

}

fun main() {

    // Lines 21 and 22 are equal. Companion object reference can be omitted
    Logging.log()
    Logging.log()

    Logging.Printer.print()
    // Companion object are similar to static methods in other languages,
    // however at runtime they are instances of real objects.
    // They can implement interfaces
    Logging.reportLog("Hello world")
}