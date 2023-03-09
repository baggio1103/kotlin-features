package examples.scopedFunctions

class Configuration(var host: String, var port: Int) {

    fun connect() {
        println("Connecting to a server with host: $host and port: $port")
    }

    override fun toString(): String {
        return "Configuration{host: $host, port: $port}"
    }

}

fun main() {
    val configuration = Configuration("http://localhost", 8888)

    // Let -> Returns the last expression after executing a block of commands inside braces
    // Referenced by using keyword - it by default
    configuration.let {
        println("Host: ${it.host}, port: ${it.port}")
         it
    }

    // Run -> Returns the last expression after executing a block of commands inside braces
    // Referenced by using keyword - this
    configuration.run {
        connect()
        this
    }

    // Apply -> Returns the instance itself after executing a block of commands inside braces
    // Referenced by using keyword - this
    configuration.apply {
        host = "https://123.21.23.88"
        port = 8998
    }
    println(configuration)


    // Apply -> Returns the instance itself after executing a block of commands inside braces
    // Referenced by using keyword - this
    configuration.apply {
        host = "https://123.21.23.88"
        port = 8998
    }
    println(configuration)

    val serverConfiguration = Configuration("https://123.232.12.22", 8888)
    serverConfiguration.connect()
    serverConfiguration.also {
        it.port = 5454
        it.host = "https://111.222.33.12"
        println("The configuration has been changes")
    }
}