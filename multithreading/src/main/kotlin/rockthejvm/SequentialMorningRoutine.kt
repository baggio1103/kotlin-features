package rockthejvm

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import reflectoring.logger as log

suspend fun main() {
    log.info("Starting morning routine")
    sequentialMorningRouting()
    log.info("Finishing morning routine")
}


suspend fun bathTime() {
    log.info("Going to the bathroom")
    delay(500)
    log.info("Exiting the bathroom")
}

suspend fun boilingWater() {
    log.info("Boiling water")
    delay(500)
    log.info("Water boiled")
}

suspend fun preparingCoffee() {
    log.info("Preparing coffee")
    delay(500)
    log.info("Coffee prepared")
}

suspend fun sequentialMorningRouting() {
    coroutineScope {
        launch {  }
        bathTime()
    }
    coroutineScope {
        boilingWater()
    }
}