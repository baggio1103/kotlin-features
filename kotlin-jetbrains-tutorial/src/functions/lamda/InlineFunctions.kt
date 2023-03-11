package functions.lamda

fun highOrderFunction(value: String, run: (String) -> Unit) {
    run(value)
}

inline fun inlinedHighOrderFunction(value: String, run: (String) -> Unit) {
    run(value)
}

fun main() {
    print("Java jedi")
    highOrderFunction(" a blog with cs topics", ::print )
    print("\nJava jedi")
    inlinedHighOrderFunction(" a blog with cs topics", ::print )
}