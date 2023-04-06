package classes.nested

class Car {

    private val topSpeed: Int = 250

    fun drive() {
        println("Driving")
    }

    inner class Wheel {

        private val wheelCount: Int = 5

        fun rotate() {
//            this@Car - reference to all the fields and methods of Car class
//            this - reference to all the fields and methods of Wheel class
            this@Car.drive()
            println("Wheels running. Wheel count: ${wheelCount}. Top speed of car: $topSpeed")
        }

    }

}

// Inner classes can access to field and methods of outer class
// To init an inner class, we need to init an outer class first.
// Otherwise, a compile time error!

fun main() {
    val car = Car()
    val wheel = car.Wheel()
    wheel.rotate()
}