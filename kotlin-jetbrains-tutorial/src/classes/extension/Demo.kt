package classes.extension


fun <T> MutableList<T>.swap(index: Int, other: Int) {
    val temp = this[index]
    this[index] = this[other]
    this[other] = temp
}

// Extension property can be only `val`
val <T> List<T>.lastIndex: Int
    get() = size - 1

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5, 6, 12)
    println("Before swap: $list")
    list.swap(0, 6)
    println("After swap:  $list")
    val lastIndex = list.lastIndex
    println("Last index: $lastIndex")
}