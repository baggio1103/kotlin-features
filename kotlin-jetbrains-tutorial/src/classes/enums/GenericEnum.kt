package classes.enums

inline fun <reified T: Enum<T>> values(): Array<T> {
    return enumValues()
}

fun main() {
    val enums = values<COLOR>()
    enums.forEach {
        println("$it")
    }
    println(enums.joinToString { it.name })
}