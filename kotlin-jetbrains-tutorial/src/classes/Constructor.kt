package classes

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