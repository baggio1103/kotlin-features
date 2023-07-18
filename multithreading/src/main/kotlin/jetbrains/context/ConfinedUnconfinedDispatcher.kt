package jetbrains.context

import kotlinx.coroutines.*

suspend fun main() {
    runBlocking {
        launch(Dispatchers.Unconfined) {
            log("Unconfined")
            delay(200)
            log("After delay resumed")
        }
        launch {
            log("Single threaded dispatcher")
            delay(200)
            log("After delay resumed too")
        }
    }
}