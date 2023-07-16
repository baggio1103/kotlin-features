package synchronization.sharedmutablestate

suspend fun main() {
    var counter = 0
    massiveRun {
        counter++
    }
    println("Counter: $counter")
}

