package jetbrains.context

import kotlinx.coroutines.*

suspend fun main() {
    coroutineScope {
        val request = launch {
            repeat(5) {
                launch(CoroutineName(""), CoroutineStart.LAZY) {
                    delay((it + 1) * 200L)
                    log("Coroutine $it is done!")
                }
            }
            log("Request: I am done and I don't explicitly join my children that are still alive")
        }
        log("Started the request!")
        request.join()
        log("Processing of the request is done!")
    }
}