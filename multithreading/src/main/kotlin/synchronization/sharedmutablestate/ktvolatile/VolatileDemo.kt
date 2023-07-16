package synchronization.sharedmutablestate.ktvolatile

import synchronization.sharedmutablestate.massiveRun

@Volatile
var counter = 0

suspend fun main() {
    massiveRun {
        counter++
    }
    println("Counter: $counter")
}