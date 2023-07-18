package jetbrains.context

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
    thread(name = "runner") {
        run()
    }
}

fun run() {
    runBlocking {
        log("Inside run blocking")
        launch {
            log("Inside coroutine of run blocking")
        }
        launch(Dispatchers.Unconfined) {
            log("Inside unconfined dispatcher")
        }
        launch(Dispatchers.Default) {
            log("Inside Default")
        }
        launch(newSingleThreadContext("single-thread-context")) {
            log("Inside single thread context")
        }
    }
}