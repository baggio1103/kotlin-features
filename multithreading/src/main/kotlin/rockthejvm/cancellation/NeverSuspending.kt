package rockthejvm.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import reflectoring.logger

/**
 * In this example, we use job.cancelAndJoin() to cancel a coroutine,
 * however a coroutine never gets cancelled, since the coroutine never
 * reaches its suspension point.
 * And the message - `Let's go to the mall!` never gets printed.
 * Besides, it causes a terrible memory leak.
 * **/
suspend fun main() {
    logger.info("Starting morning routine")
    forgettingBirthday()
    logger.info("Finishing morning routine")
}

suspend fun forgettingBirthday() {
    coroutineScope {
        val job = launch {
            workingHard()
        }
        launch {
            job.cancelAndJoin()
            logger.info("I forgot the birthday. Let's go to the mall!")
        }
    }
}

suspend fun workingHard() {
    logger.info("Working hard")
    while (true) {

    }
    logger.info("Done")
}