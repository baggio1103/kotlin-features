package functions.operators

data class Counter(val dayIndex: Int) {

    operator fun plus(increment: Int): Counter {
        return Counter(increment + dayIndex)
    }

}

fun main() {
    val counter = Counter(11)
    val newCounter = counter + 12
    println(newCounter)
}