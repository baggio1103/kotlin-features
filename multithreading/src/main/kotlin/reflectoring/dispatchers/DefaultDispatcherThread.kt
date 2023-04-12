package reflectoring.dispatchers

import kotlinx.coroutines.delay
import reflectoring.logger
import reflectoring.netWorkCall
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() {
    val execTime = measureTimeMillis {
        repeat (2000)       {
            thread {
                logger.info("Executing a network call")
                Thread.sleep(1000)
            }
        }
    }
    logger.info("Exec time: $execTime")
}