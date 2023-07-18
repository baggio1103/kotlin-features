package jetbrains.context

import kotlinx.coroutines.*

suspend fun main() {

    coroutineScope {
        repeat(3) {
            launch(Dispatchers.Default + CoroutineName("launcher")) {
                log("Hello world inside coroutine: ${it + 1}")
                delay(100)
            }
        }
    }

}