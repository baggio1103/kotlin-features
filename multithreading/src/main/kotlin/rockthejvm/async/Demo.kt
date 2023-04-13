package rockthejvm.async

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import reflectoring.logger

suspend fun main() {
    coroutineScope {
        val coffee = async {
            preparingJavaCoffee()
        }
        val bread = async {
            toastBread()
        }
        logger.info("I am eating ${bread.await()} and drinking ${coffee.await()}")
    }
}

suspend fun preparingJavaCoffee(): String {
    logger.info("Preparing coffee")
    delay(500)
    logger.info("Coffee prepared")
    return "Java Coffee prepared"
}

suspend fun toastBread(): String {
    logger.info("Toasting bread")
    delay(500)
    logger.info("Bread toasted")
    return "Toasted bread"
}