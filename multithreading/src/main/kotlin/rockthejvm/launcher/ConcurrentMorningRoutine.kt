package rockthejvm.launcher

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import reflectoring.logger
import rockthejvm.bathTime
import rockthejvm.boilingWater

suspend fun main() {

    concurrentMorningRoutine()

}

suspend fun concurrentMorningRoutine() {
    logger.info("Starting morning routine")
    coroutineScope {
        launch {
            bathTime()
        }
        launch {
            boilingWater()
        }
    }
    logger.info("Finishing morning routine")
}