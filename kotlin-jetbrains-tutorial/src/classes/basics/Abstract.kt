package classes.basics

abstract class Polygon {

    abstract fun draw()

}

class Rectangle: Polygon() {

    override fun draw() {
        println("Drawing rectangle")
    }

}

fun main() {

    val polygon: Polygon = Rectangle()
    polygon.draw()

}