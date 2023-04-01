package classes.extension

class Robot {

    companion object {
        const val value = "JARVIS"
    }

}

fun Robot.Companion.printInfo() {
    println("My name is $value")
}

fun main() {
    val companion = Robot.Companion
    println(Robot.value)
    companion.printInfo()
}