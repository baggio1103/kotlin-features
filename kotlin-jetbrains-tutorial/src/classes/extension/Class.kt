package classes.extension

class Polygon {

    fun draw() {
        println("Drawing from Polygon member function")
    }

}

fun Polygon.draw() {
    println("Drawing from Polygon extension function")
}

//If a class has a member function and extension function
// with the same signature and arguments, then
// a member function will execute, since it has the highest priority
fun main() {
    val polygon = Polygon()
    polygon.draw()
}