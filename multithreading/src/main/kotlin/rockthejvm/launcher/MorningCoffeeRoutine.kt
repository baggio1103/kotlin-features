package rockthejvm.launcher

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import reflectoring.logger
import rockthejvm.bathTime
import rockthejvm.boilingWater
import rockthejvm.preparingCoffee

suspend fun main() {
    logger.info("Starting morning routine")
    morningRoutineWithCoffee()
    logger.info("Finishing morning routine")
}

suspend fun morningRoutineWithCoffee() {
    coroutineScope {
        val bathJob = launch {
            bathTime()
        }
        val boilingJob = launch {
            boilingWater()
        }
        bathJob.join()
        boilingJob.join()
        launch {
            preparingCoffee()
        }
    }
}