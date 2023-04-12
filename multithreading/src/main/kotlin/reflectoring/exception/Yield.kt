package reflectoring.exception

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import reflectoring.logger

fun main() = runBlocking {
    logger.info("Starting execution")
    try {
        val jobOne = launch {
            repeat(20) {
                delay(100)
                logger.info("JobOne execute task: $it")
                yield()
            }
        }
        val jobTwo = launch {
            repeat(20) {
                delay(100)
                logger.info("JobTwo execute task: $it")
                yield()
            }
        }
        delay(2000)
        jobOne.cancel()
        jobTwo.cancel()
    } catch (ex: Exception) {
        logger.error("Exception happened: ${ex.message}")
    }
    logger.info("Finishing execution")
}