package jetbrains.context

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    log("Main started")
    coroutineScope {
        log("Hello, i am launching coroutine")
        val job = launch {
            log("Running inside coroutine")
        }
        launch {
            log("Hello")
            delay(100)
        }
        job.join()
        log("Coroutine scope end")
    }
    log("Finished")
}