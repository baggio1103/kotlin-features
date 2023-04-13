package rockthejvm.scheduling

import kotlinx.coroutines.*
import reflectoring.logger

suspend fun main() {
    logger.info("Starting working so hard")
    workingHardRoutine()
    logger.info("Finishing working hard")
}

suspend fun hello() {
    logger.info("Hello")
    delay(3000)
    logger.info("Nice to meet you")
}

suspend fun bye() {
    logger.info("Bye")
    delay(2000)
    logger.info("See you soon")
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun workingHardRoutine() {
    val dispatcher = Dispatchers.Default.limitedParallelism(1)
    coroutineScope {
        launch(dispatcher) {
            workingHard()
        }
        launch(dispatcher) {
            takeABreak()
        }
    }
}

suspend fun workingHard() {
    logger.info("Working")
    while (true) {

    }
    delay(100)
    logger.info("Done")
}

suspend fun takeABreak() {
    logger.info("Taking a break")
    delay(500)
    logger.info("Break done")
}