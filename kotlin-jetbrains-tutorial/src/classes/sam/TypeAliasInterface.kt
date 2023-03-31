package classes.sam

typealias Predicate<T> = (value: T) -> Boolean

fun main() {
    val isEven : Predicate<Int> =  {
        value -> value / 2 == 0
    }
    println("Is 7 even? - ${isEven(7)}")
    println("Is 10 even? - ${isEven(10)}")
    println("Is 21 even? - ${isEven(21)}")
}