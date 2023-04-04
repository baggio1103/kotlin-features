package classes.generics

interface Source<out T> {

    fun nextValue(): T

}

fun demo(source: Source<String>) {
    val newSource: Source<Any> = source

}