package synchronization

class Counter {

    private var counter: Int = 0

    fun increment() {
        counter++
    }

    fun logCounter() {
        println("Counter: $counter")
    }

}