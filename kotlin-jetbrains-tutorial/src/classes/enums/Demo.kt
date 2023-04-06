package classes.enums

enum class Direction {
    NORTH, WEST, SOUTH, EAST
}

fun main() {
    println(Direction.values().forEach { println(it) })
}