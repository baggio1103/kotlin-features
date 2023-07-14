package synchronization.volatile

import kotlinx.coroutines.delay
import org.apache.log4j.Logger

class Shop {

    var isOpen = false

    private val log: Logger = Logger.getLogger("shop")

    suspend fun sell() {
        while (!isOpen) {
            log.info("Waiting...")
            delay(1000)
        }
        log.info("Selling products....")
    }

}