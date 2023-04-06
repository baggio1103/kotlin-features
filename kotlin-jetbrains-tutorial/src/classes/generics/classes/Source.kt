package classes.generics.classes

//interface Source<out T> {
//
//    fun nextValue(): T
//
//}

class Source<out T>(val value: T) {

    fun nextValue() = value

}

fun demo(source: Source<String>) {
    val newSource: Source<Any> = source

}