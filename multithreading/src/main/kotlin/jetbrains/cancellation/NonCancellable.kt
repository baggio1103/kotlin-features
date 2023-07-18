package jetbrains.cancellation

import kotlinx.coroutines.*

/**
 * This example shows that although the coroutine is cancelled,
 * it still works since there is no check for cancellation.
 * It will work until the condition inside while loop is met
 * To achieve cancellation, either check for cancellation
 * or call a suspending function inside a coroutine.
 * */
suspend fun main() {

    coroutineScope {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 15) {
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("Job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(2000)
        println("I am tired of waiting...")
        job.cancelAndJoin()
        println("I am quiting...")
    }

}