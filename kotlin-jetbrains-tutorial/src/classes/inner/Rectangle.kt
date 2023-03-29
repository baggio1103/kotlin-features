package classes.inner

open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle: Rectangle() {

    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        private fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledRectangle.draw()
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
    }
}

fun main() {
    val fr = FilledRectangle()
    fr.draw()

    val innerFiller = FilledRectangle().Filler()
    innerFiller.drawAndFill()
}