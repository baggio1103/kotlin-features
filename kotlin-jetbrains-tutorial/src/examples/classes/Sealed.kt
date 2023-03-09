package examples.classes

sealed class Mammal(val name: String)

class Cat(catName: String): Mammal(catName)

class Human(humanName: String, val job: String): Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    return when (mammal) {
        is Cat -> "Hello ${mammal.name}" // Automatically performed smart cast, interacting with a cat class instance
        is Human -> "Hello ${mammal.name}, You are working as a ${mammal.job}" // Automatically performed smart cast, interacting with a human class instance
    }
}

fun main() {
    val cat = Cat("Tom")
    println(greetMammal(cat))
    val human = Human("Tommy", "babysitter")
    println(greetMammal(human))
}

