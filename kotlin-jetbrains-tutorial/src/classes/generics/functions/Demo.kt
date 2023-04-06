package classes.generics.functions

import examples.controlFlow.Animal

fun <T> singletonList(item: T): List<T> {
    return listOf(item)
}

fun <T> T.basicToString(): String {
    return "To string ${this.toString()}"
}

// T: Comparable<T> => upper bound of T.
// Only subtypes of T can be passed to the function
fun <T: Comparable<T>> sort(list: List<T>, sth: T) {

}

//When we need to implement two interface, we need to specify it
// in the `where` clause. In angle brackets only
// one upper bound type can be specified
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String> where
        T: CharSequence, T: Comparable<T> {
    return emptyList()
}

fun <T> iterate(sth: T) {
    if (sth is List<*>) {
        sth.filterNotNull().forEach {
            println(it)
        }
    }
}

fun main() {

    val list = singletonList(1)
    print(list)
    val value = Animal("Richie").basicToString()
    println(value)
}