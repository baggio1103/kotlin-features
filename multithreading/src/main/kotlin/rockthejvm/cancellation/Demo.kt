package rockthejvm.cancellation

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import reflectoring.logger

/***
 * job.cancel() and job.join() are used to cancel coroutine.
 * job.cancelAndJoin() is a function that replaces them both.
 * However, in order to cancel a coroutine, the coroutine must
 * reach its suspension point. Otherwise, a coroutine never gets cancelled.
 * To demonstrate this, I will change workingConscious() that is a suspending function
 *  to a function that never reaches suspension point.
 * */
suspend fun main() {
    logger.info("Starting morning routine")
    forgettingTheBirthDayRoutine()
    logger.info("Finishing morning routine")
}

suspend fun forgettingTheBirthDayRoutine() {
    coroutineScope {
        val job = launch {
            workingConscious()
        }
        launch {
            delay(3000)
            job.cancel()
            job.join()
            logger.info("I forgot the birthday!")
        }
    }
}
suspend fun workingConscious() {
    logger.info("Working")
    while (true) {
        delay(300)
    }
    logger.info("Done")
}