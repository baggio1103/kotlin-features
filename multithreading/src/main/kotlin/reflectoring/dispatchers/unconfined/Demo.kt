package reflectoring.dispatchers.unconfined

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import reflectoring.logger
import reflectoring.netWorkCall

fun main() = runBlocking {
    launch(Dispatchers.Unconfined) {
      logger.info("Starting coroutine")
        netWorkCall()
    }
    logger.info("Finished execution")
}