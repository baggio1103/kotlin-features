package classes

// A primary constructor is a constructor that comes right after
// the name of a class and optional type parameters.
// A class may have one primary constructor
// and several secondary constructors

class Customer(private val name: String = "baggio") {

    private val length = name.length

    init {
        println("Name length: $length")
    }

    override fun toString(): String {
        return "Customer: $name"
    }

}

fun main() {
    val customer = Customer()
    println(customer)
}