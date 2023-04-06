package classes.generics.classes

interface Comparable<in T> {

    fun compare(other: T): Int

}

fun demo(x: Comparable<Number>) {
    x.compare(1.0)
    val y: Comparable<Double> = x
}