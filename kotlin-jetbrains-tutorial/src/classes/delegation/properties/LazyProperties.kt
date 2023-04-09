package classes.delegation.properties

val lazyValue: String  by lazy {
    println("Executing lazy init function")
    "Lazy Value"
}

// Lazy is function that take a lambda and returns an instance of Lazy<T>
// The first call to get() executes the passed lambda and remembers the result.
// Next call to get() returns the earlier remembered result
fun main() {
    println(lazyValue)
    println(lazyValue)
    println(lazyValue)
    println(lazyValue)
}