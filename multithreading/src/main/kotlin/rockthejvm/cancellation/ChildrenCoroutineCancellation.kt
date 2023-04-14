package rockthejvm.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import reflectoring.logger

suspend fun main() {
    logger.info("Starting the morning coroutine")
    forgettingBirthdayWhileWorkingAndDrinkingWater()
    logger.info("Finishing morning coroutine")
}

suspend fun forgettingBirthdayWhileWorkingAndDrinkingWater() {
    coroutineScope {
        val workingJob = launch {
            launch {
                workingConscious()
            }
            launch {
                drinkWater()
            }
        }
        launch {
            delay(2000)
            workingJob.cancelAndJoin()
            logger.info("I forgot the birthday! Let's go to the mall!")
        }
    }
}

suspend fun drinkWater() {
    while (true) {
        logger.info("Drinking water")
        delay(500)
        logger.info("Water drunk")
    }
}