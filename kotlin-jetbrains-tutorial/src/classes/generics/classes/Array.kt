package classes.generics.classes


fun main() {
    val ints : Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "Hello" }
    copy(ints, any)
    any.forEach { println(it) }
    ints.forEach { println(it) }
}

fun copy(from: Array<out Any>, to: Array<in Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}