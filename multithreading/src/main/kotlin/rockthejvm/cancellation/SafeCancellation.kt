package rockthejvm.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import reflectoring.logger

suspend fun main() {
    logger.info("Starting morning routine")
    forgettingTheBirthdayAndCleaningTheDesk()
    logger.info("Finishing morning routine")
}

suspend fun forgettingTheBirthdayAndCleaningTheDesk() {
    val desk = Desk()
    coroutineScope {
        val workingJob = launch {
            desk.use {
                workingConscious()
            }
            workingConscious()
        }
//        Another way to clean up the resources is to use invokeOnCompletion,
//        it receives a nullable Throwable as an argument,
//        the ex why the coroutine was cancelled
//        workingJob.invokeOnCompletion { ex: Throwable? ->
//            logger.info(ex)
//            desk.close()
//        }
        launch {
            delay(2000)
            workingJob.cancelAndJoin()
            logger.info("I forgot the birthday. Let's go to the mall.")
        }
    }
}