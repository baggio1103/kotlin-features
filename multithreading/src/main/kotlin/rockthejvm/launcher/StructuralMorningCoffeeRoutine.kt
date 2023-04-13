package rockthejvm.launcher

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import reflectoring.logger
import rockthejvm.bathTime
import rockthejvm.boilingWater
import rockthejvm.preparingCoffee

suspend fun main() {
    logger.info("Starting morning routine")
    structuralMorningCoffeeRoutine()
    logger.info("Starting morning routine")
}

suspend fun structuralMorningCoffeeRoutine() {
    coroutineScope {
        coroutineScope {
            launch {
                bathTime()
            }
            launch {
                boilingWater()
            }
        }
        preparingCoffee()
    }
}