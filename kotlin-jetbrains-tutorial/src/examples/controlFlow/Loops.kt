package examples.controlFlow

fun loops() {
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
}

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

fun doWhileLoop() {
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatACake()
        cakesEaten ++
    }
    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

class Animal(val name: String) {
    override fun toString(): String {
        return "Animal{name: ${name}}"
    }
}

class Zoo(private val animals: List<Animal>) {
    operator fun iterator() = animals.iterator()
}

fun main() {
    println("For loop")
    loops()
    println("\nDo While Loop")
    doWhileLoop()
    println("\nIterating over list of animals")
    val zoo = Zoo(listOf(Animal("Zebra"), Animal("Lion")))
    for (animal in zoo) {
        println(animal)
    }
}