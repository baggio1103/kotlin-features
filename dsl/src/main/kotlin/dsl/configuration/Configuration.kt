package dsl.configuration

data class Setting(var name: String = "", var value: Int = 0)

class Configuration {

    private val settings = mutableListOf<Setting>()

    fun setting(block: Setting.() -> Unit) {
        settings.add(
            Setting().apply(block)
        )
    }

    override fun toString(): String {
        return settings.joinToString("\n") { "${it.name}=${it.value}" }
    }

}

fun configuration(block: Configuration.() -> Unit): Configuration {
    return Configuration().apply(block)
}

fun main() {
    val configuration = configuration {
        setting {
            name = "ServerPort"
            value = 8080
        }
        setting {
            name = "Database"
            value = 5432
        }
    }
    println("Configuration:\n$configuration")
}