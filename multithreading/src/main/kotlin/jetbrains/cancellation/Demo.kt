package jetbrains.cancellation

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.apache.log4j.Logger

val log: Logger = Logger.getLogger("jetbrains/cancellation")

suspend fun main() {
    coroutineScope {
        log.info("Started coroutine scope")
        val job = launch {
            repeat(100) {
                log.info("Job: I am sleeping $it time")
                delay(500)
            }
        }
        log.info("I am waiting for 2 more seconds")
        delay(2000)
        job.cancel()
        log.info("Main: Now i can quit")
    }
}