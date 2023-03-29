package classes.inheritance

open class Rectangle {

    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"

}

class FilledRectangle(val name: String): Rectangle() {

    override fun draw() {
        super.draw()
        println("Filling a rectangle")
    }

    val fillColor: String get() = super.borderColor

}


fun main() {
    val rectangle = Rectangle()
    println(rectangle.borderColor)
    rectangle.draw()
    println("-----------------------------------")
    val filledRectangle = FilledRectangle("Parallelogram")
    println("Name of rectangle: ${filledRectangle.name}")
    println("Fill color: ${filledRectangle.fillColor}")
}