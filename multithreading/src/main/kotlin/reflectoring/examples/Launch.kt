package reflectoring.examples

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import reflectoring.logger

/**
 * Launching two coroutines, they execute in parallel using main thread.
 * */
fun main() = runBlocking {
    logger.info("Starting execution")
    val deferredYoutube = async {
        delay(2000)
        "Network call to youtube.com"
    }
    val deferredGoogle =  async {
        delay(4000)
        "Network call to google.com"
    }
    logger.info("Result: ${deferredYoutube.await()}")
    logger.info("Result: ${deferredGoogle.await()}")
    logger.info("Finishing execution")
}