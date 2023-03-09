package examples.classes

import examples.classes.State.*

enum class State {
    IDLE, RUNNING, FINISHED
}

enum class Color(private val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed(): Boolean = this.rgb.and( 0xFF0000) != 0

}
    fun main() {
        val message = when (FINISHED) {
            IDLE -> "It is idling"
            RUNNING -> "It is running"
            FINISHED -> "It is finished"
        }
        println(message)
        println("\nColors")
        val red = Color.RED
        println(red)
        println(red.containsRed())
        println(Color.BLUE.containsRed())
        println(Color.YELLOW.containsRed())
        println(Color.GREEN.containsRed())
    }