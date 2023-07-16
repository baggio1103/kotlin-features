package synchronization.sharedmutablestate.threadconfinement

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import synchronization.sharedmutablestate.massiveRun

/**
 * This example demonstrates the problem of accessing
 * shared state across different threads and coroutines.
 * Several solutions are given to solve this problem.
 *
 * Fine-grained thread confinement solves this by switching
 * all the running threads from multi-threaded Dispatcher to
 * a single threaded context. Thus, it takes much time to complete,
 * since context switching is an expensive operation
 *
 * Coarse grained thread confinement means running all coroutines
 * in one thread. Thus, it solves the problem of shared state, and
 * it gives the best performance
 * */


@OptIn(DelicateCoroutinesApi::class)
val counterContext = newSingleThreadContext("counter-context")

suspend fun main() {
    println("Fine grained thread confinement execution")
    fineGrained()
    println("Fine grained finished execution\n")

    println("Coarse grained thread confinement execution")
    coarseGrained()
    println("Coarse grained finished execution\n")

    println("Executing without being confined to any thread")
    nonSyncCounter()
    println("Non thread confined context execution finished\n")

    println("Executing counter with mutex")
    mutexCounter()
    println("Counter execution with mutex finished")
}

suspend fun fineGrained() {
    var counter = 0
    withContext(Dispatchers.Default) {
        massiveRun {
            withContext(counterContext) {
                counter++
            }
        }
    }
    println("Counter: $counter")
}

suspend fun coarseGrained() {
    var counter = 0
    withContext(counterContext) {
        massiveRun {
            counter++
        }
    }
    println("Counter: $counter")
}

suspend fun nonSyncCounter() {
    var counter = 0
    massiveRun {
        counter++
    }
    println("Counter: $counter")
}

suspend fun mutexCounter() {
    var counter = 0
    val mutex = Mutex()
    massiveRun {
        mutex.withLock {
            counter++
        }
    }
    println("Counter: $counter")
}