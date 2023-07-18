package jetbrains.cancellation

import kotlinx.coroutines.*

/**
 * To stop coroutine, you either need to call a suspending function periodically,
 * yield() suits best for this purpose
 * or check implicitly that coroutine is active by checking it is still active - `isActive`
 * */
suspend fun main() {
    coroutineScope {
        val job = launch {
            var i = 0
            while (isActive) {
                log.info("Job: i am sleeping ${i++} time...")
                delay(1000)
            }
        }
        delay(2000)
        log.info("I am tired of waiting...")
        job.cancelAndJoin()
        log.info("Main: I am quiting...")
    }
}