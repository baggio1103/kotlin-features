package reflectoring

import org.apache.log4j.Logger
import kotlin.concurrent.thread

val logger: Logger = Logger.getLogger("CoroutineLogger")

fun main() {
    logger.info("My program runs")
    thread {
        longRunningTask()
    }
    logger.info("My program ends")
}

fun longRunningTask(){
    logger.info("Executing longRunningTask on...")
    Thread.sleep(1000)
    logger.info("LongRunningTask ends on thread ...")
}