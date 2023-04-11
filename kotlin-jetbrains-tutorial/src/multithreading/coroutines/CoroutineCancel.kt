package multithreading.coroutines

import kotlinx.coroutines.*

/**
 *  job.cancel() - cancel a coroutine if it is not completed.
 *  job.active - returns current state of a coroutine
 **/
fun main() {
    val job = GlobalScope.launch {
        repeat(5) {
            println("Coroutine is still working")
            delay(1000L)
        }
        println("Coroutine has finished executing")
    }
    runBlocking {
        delay(3000L)
        job.cancel("Too much time", RuntimeException("Time out"))
        println("Main Thread is continuing")
    }
    println("Exiting...")
}
