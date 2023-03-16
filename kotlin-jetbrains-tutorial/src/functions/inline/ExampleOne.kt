package functions.inline

inline fun higherOrderFunc(string: String, lambda: (String) -> Unit) {
    lambda(string)
}

fun main() {
    print("Java Jedi")
    higherOrderFunc(
        " - blog for CS enthusiasts"
    ) {
        println(it)
        return@higherOrderFunc
    }
}