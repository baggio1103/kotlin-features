package classes.inlines

@JvmInline
value class Name(private val word: String) {

    init {
        require(word.length > 5) {
        }
    }

    val length: Int
        get() = word.length

    fun greet() {
        println("Hello, $word")
    }

}

// At runtime, method greet() is called as a static method
// Property getter is called as a static method
fun main() {
    val name = Name("Kotlin")
    name.greet()
    println(name.length)
}