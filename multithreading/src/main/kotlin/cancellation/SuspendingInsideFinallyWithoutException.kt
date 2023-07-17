package cancellation

import kotlinx.coroutines.*

suspend fun main() {
    coroutineScope {
        val job = launch {
            try {
                repeat(10) {
                    println("Job: I am sleeping $it time ...")
                    delay(500)
                }
            } finally {
                withContext(NonCancellable) {
                    println("Job: I am running finally")
                    delay(100)
                    println("Job: I have just delayed finally block for 100ms")
                }
            }
        }
        delay(2000)
        println("Tired of waiting...")
        job.cancelAndJoin()
        println("Main: i am quiting...")
    }
}