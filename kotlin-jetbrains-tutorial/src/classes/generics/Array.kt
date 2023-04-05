package classes.generics


fun main() {

    val ints : Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    println(any)
    any.forEach { println(it) }

}