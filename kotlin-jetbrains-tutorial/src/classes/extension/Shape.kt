package classes.extension

open class Shape

class Rectangle: Shape()

fun Shape.getName() = "Shape"

fun Rectangle.getName() = "Rectangle"

// Even if Shape has subclasses that have an extension function getName()
// only the extension function of Shape will be called
fun printClassName(s: Shape) {
    println(s.getName())
}

// Extension function of Rectangle will be called, even if its parent classes have
// the same Extension function.
// Extension function depends only on the type declared
fun printClassName(rectangle: Rectangle) {
    println(rectangle.getName())
}

fun main() {
    printClassName(Shape())
    printClassName(Rectangle())
}