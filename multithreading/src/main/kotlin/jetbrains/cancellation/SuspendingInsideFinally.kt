package jetbrains.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        val job = launch {
            try {
                repeat(100) {
                    println("Job: I am sleeping $it ...")
                    delay(1000)
                }
            } finally {
//                delay(100)
//                Calling suspending function here
//                causes exception, the next line will not execute
                println("Oops, it is cancelled")
            }
        }
        delay(2000)
        println("I am tired of waiting...")
        job.cancelAndJoin()
        println("Main: i am quiting")
    }
}