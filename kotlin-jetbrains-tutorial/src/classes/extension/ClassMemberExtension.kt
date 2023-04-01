package classes.extension

class Host(val value: String) {

    fun printHostName() {
        print("Host: $value")
    }

}

class Connection(private val host: Host, private val port: Int) {

     private fun printPort() {
        print(port)
    }


// If Extension function is defined as class member function,
// it can be used only inside that class, invisible outside that class
      private fun Host.printConnectionString() {
        printHostName()
        print(":")
        printPort()
    }

    fun connect()  {
        host.printConnectionString()
    }

}

fun main() {
    val connection = Connection(Host("github.com"), 8080)
    connection.connect()
    Host("").printHostName()
}