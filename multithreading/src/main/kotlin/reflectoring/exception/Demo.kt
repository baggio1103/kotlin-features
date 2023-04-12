package reflectoring.exception

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import reflectoring.logger

fun main() = runBlocking {
    logger.info("Starting execution")
    val job = launch {
        dbCall()
    }
    delay(2000)
    job.cancel()
    job.join()
    job.cancelAndJoin() // the same job.cancel() and job.join() simultaneously executed
}

suspend fun dbCall() {
    repeat(1000) {
        logger.info("Executing queries")
        delay(100)
        logger.info("Queries execution finished")
    }
}