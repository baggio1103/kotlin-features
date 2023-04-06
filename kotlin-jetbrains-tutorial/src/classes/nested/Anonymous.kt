package classes.nested

interface Move {

    fun drive()

}

abstract class Vehicle(val name: String): Move

fun main() {
    val vehicle = object : Vehicle("Ferrari") {

        override fun drive() {
            println("Driving car: $name")
        }

    }
    vehicle.drive()
}