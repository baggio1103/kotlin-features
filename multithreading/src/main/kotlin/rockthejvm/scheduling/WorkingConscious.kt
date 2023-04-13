package rockthejvm.scheduling

import kotlinx.coroutines.*
import reflectoring.logger
import java.util.concurrent.Executors

/**
 * The output of WorkingConscious and CustomerDispatcher are the same.
 * Although, WorkingConscious uses only one thread,
 * it is able to launch two coroutines, because workingConscious() uses a delay() to reach suspension.
 * While the example in the CustomerDispatcher.kt, the program is able to launch two coroutine
 * only because it uses two threads, one of which gets blocked infinitely in the while(true) {} loop
 * */
suspend fun main() {
    logger.info("Starting working hard...")
    workingHardConsciousRoutine()
    logger.info("Finished working so hard...")
}

suspend fun workingConscious() {
    logger.info("Working")
    while (true) {
        delay(100)
        logger.info("Resumed working")
    }
    logger.info("Work done")
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun workingHardConsciousRoutine() {
    val dispatcher = Dispatchers.Default.limitedParallelism(1)
    coroutineScope {
        launch(dispatcher) {
            workingConscious()
        }
        launch { takeABreak() }
    }
}