package reflectoring.dispatchers.defaults

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import reflectoring.logger
import reflectoring.netWorkCall
import kotlin.system.measureTimeMillis

/**
 * DEFAULT DISPATCHER - limitedParallelism(n) created a thread pool with n - threads
 * that run all the coroutines in parallel.
 * */
@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {
    val execTime = measureTimeMillis {
        repeat(1000) {
            launch(Dispatchers.Default.limitedParallelism(3)) {
                logger.info("Default Dispatcher Coroutine is running $it task")
                netWorkCall()
            }
        }
    }
    logger.info("Exec time: $execTime")
}