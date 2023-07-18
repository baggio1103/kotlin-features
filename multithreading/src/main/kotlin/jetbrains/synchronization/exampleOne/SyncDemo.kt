package jetbrains.synchronization.exampleOne

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.apache.log4j.Logger

suspend fun main() {

    val mutexCounter = MutexCounter()

    val log: Logger = Logger.getLogger("main")

    coroutineScope {
        launch {
            for (i in 1 .. 10_000) {
                mutexCounter.increment()
            }
        }
        log.info("Launched first coroutine")
        launch {
            for (i in 1 .. 5_000) {
                mutexCounter.increment()
            }
        }
        log.info("Launched second coroutine")
    }
    mutexCounter.counterValue()
}
