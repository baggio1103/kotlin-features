package classes.basics

open class Shape {

    open fun draw() {
        println("Drawing random shape")
    }

}

abstract class WildShape: Shape() {

    abstract override fun draw()

}

class WildTriangleShape: WildShape() {

    override fun draw() {
        println("Drawing a wild triangle shape")
    }

}

fun main() {
   val wildTriangleShape = WildTriangleShape()
    wildTriangleShape.draw()
}