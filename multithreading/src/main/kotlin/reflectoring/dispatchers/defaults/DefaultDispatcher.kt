package reflectoring.dispatchers.defaults

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import reflectoring.logger
import reflectoring.netWorkCall
import kotlin.system.measureTimeMillis

/**
 * DEFAULT DISPATCHER has a thread pool of 10 threads
 * that run all the coroutines in parallel.
 * */
fun main() = runBlocking {
    val execTime = measureTimeMillis {
        repeat(10000) {
            launch(Dispatchers.Default) {
                logger.info("Default Dispatcher Coroutine is running $it task")
                netWorkCall()
            }
        }
    }
    logger.info("Exec time: $execTime")
}