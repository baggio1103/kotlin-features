package rockthejvm.scheduling

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import reflectoring.logger
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

suspend fun main() {
    logger.info("Starting working so hard")
    workingHardWithCustomerDispatcher()
    logger.info("Finishing working hard")
}

suspend fun workingHardWithCustomerDispatcher() {
    val dispatcher = Executors.newFixedThreadPool(2).asCoroutineDispatcher()
    coroutineScope {
        launch(dispatcher) {
            workingHard()
        }
        launch(dispatcher) {
            takeABreak()
        }
    }
}
