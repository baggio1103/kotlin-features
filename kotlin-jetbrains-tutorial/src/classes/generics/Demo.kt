package classes.generics

class Box<T>(val value: T) {

    fun printInfo() {
        println("Value: $value")
    }

}

fun main() {
    val box = Box(10000)
    box.printInfo()
}