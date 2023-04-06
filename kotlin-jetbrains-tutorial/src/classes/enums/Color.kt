package classes.enums

enum class COLOR(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

fun main() {
    println(COLOR.RED.rgb)
    println(COLOR.GREEN.rgb)
    println(COLOR.BLUE.rgb)
}