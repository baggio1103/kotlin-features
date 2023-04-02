package classes.extension

// Extension functions are visible
// from the original class. However, if you still have access to
// the original class, there is no meaning of extension functions,
// since its better to define it inside the original class
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