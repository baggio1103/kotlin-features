package reflectoring.exception

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import reflectoring.logger

fun main() = runBlocking {
    logger.info("Starting execution")
    launch {
        delay(4000)
        logger.info("Network call to youtube.com")
    }
    launch {
        delay(2000)
        logger.info("Network call to google.com")
    }
    logger.info("Finishing execution")
}