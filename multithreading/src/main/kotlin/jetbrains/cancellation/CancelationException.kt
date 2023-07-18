package jetbrains.cancellation

import kotlinx.coroutines.*

/**
 *
 * Calling a suspending function inside a canceled coroutine
 * causes an exception and stop the coroutine,
 * if you catch the exception and do not rethrow the exception,
 * then the program will run infinitely
 * */

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        repeat(5) { i ->
            // print a message twice a second
            try {
                println("job: I'm sleeping $i ...")
                delay(500)
            } catch (e: Exception) {
                // log the exception
                println(e)
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}