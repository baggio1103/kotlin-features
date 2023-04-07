package classes.`object`

open class Circle(val radius: Int) {

    open fun draw() {
        println("Drawing a circle with a radius: $radius")
    }

}

fun draw(circle: Circle) {
    circle.draw()
}

fun anonymousFunction() = object {
    val value: Int = 1000
    override fun toString(): String {
        return "Value: $value"
    }
}


fun main() {
    val circle = Circle(10)
    circle.draw()

    // This is called object expression.
    // It is used to declare objects of anonymous classes
    val redCircle = object : Circle(20) {
        override fun draw() {
            println("Anonymous Red circle is drawing with radius - $radius")
        }
    }
    redCircle.draw()

    // object keyword is used to create an anonymous class
    // instead of creating a subtype of some class
    draw(object : Circle(100) {
        override fun draw() {
            println("Anonymous circle is drawing... ")
        }
    }
    )

    val anonymousObject = object {
        val value: Int = 10
    }
    println("Anonymous object value: ${anonymousObject.value}")
    println(anonymousFunction())
}
