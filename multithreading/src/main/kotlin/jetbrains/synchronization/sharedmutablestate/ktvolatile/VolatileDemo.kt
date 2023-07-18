package jetbrains.synchronization.sharedmutablestate.ktvolatile

import jetbrains.synchronization.sharedmutablestate.massiveRun

@Volatile
var counter = 0

suspend fun main() {
    massiveRun {
        counter++
    }
    println("Counter: $counter")
}