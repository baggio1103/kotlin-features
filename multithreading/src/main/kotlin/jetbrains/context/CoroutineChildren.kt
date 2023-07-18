package jetbrains.context

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val request = launch {

            launch(Job()) {
                log("Job 1: I run in my own job and execute independently")
                delay(1000)
                log("Job 1: I am not affected by the cancellation of of the request")
            }

            launch {
                delay(100)
                log("Job 2: I am a child of the request coroutine")
                delay(1000)
                log("Job 2: I will not execute this line of code if parent coroutine gets canceled!")
            }

        }
        delay(500)
        request.cancel()
        log("Main: who has survived the request cancellation?")
        delay(1000)
    }
}