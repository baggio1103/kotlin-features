package classes.inheritance

interface Polygon {

    fun draw() {
        println("Drawing a polygon")
    }

}

class Square: Rectangle(), Polygon {

    override fun draw() {
        super<Rectangle>.draw()
        super<Polygon>.draw()
        println("Filling square")
    }

}

class Triangle: Polygon {

    override fun draw() {
        println("Drawing a triangle")
    }

}

fun main() {
    val square = Square()
    square.draw()
}