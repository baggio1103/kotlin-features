package rockthejvm.launcher

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import reflectoring.logger
import rockthejvm.bathTime
import rockthejvm.boilingWater

suspend fun main() {
    logger.info("Starting no structural routine")
    noStructuralConcurrencyMorningRoutine()
    logger.info("Finishing no structural routine")
}
suspend fun noStructuralConcurrencyMorningRoutine() {
    GlobalScope.launch {
        bathTime()
    }
    GlobalScope.launch {
        boilingWater()
    }
    Thread.sleep(1500)
}