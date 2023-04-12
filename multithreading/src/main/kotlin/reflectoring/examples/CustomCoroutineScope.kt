package reflectoring.examples

import kotlinx.coroutines.*
import reflectoring.logger
import kotlin.coroutines.EmptyCoroutineContext

fun main() = runBlocking {
    logger.info("${this.coroutineContext}")
    logger.info("Starting exec")
    val job = launch(EmptyCoroutineContext, CoroutineStart.DEFAULT) {
        dbCall()
    }

    job.join()

    logger.info("Finishing exec")
}

suspend fun dbCall() {
    logger.info("Executing db queries")
    delay(2000)
    logger.info("Finished db queries")
}