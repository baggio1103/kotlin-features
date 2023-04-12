package reflectoring

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    logger.info("Starting execution")
    launch(Dispatchers.Unconfined) {
        val response = netWorkCall()
        logger.info("Network call to $response has been made successfully")
    }
    logger.info("Finishing execution")
}

suspend fun netWorkCall(): String {
    logger.info("Executing a network call")
    delay(1000)
    return "Youtube"
}