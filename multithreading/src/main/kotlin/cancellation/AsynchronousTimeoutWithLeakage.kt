package cancellation

import kotlinx.coroutines.*


/**
 * This example shows that withTimeout(x) and block of code
 * execute asynchronously, that is, you can open resources inside block
 * but timeout exceeds and exception is thrown but the resources are open and leakage
 * occurs. that is horrible.
 * */
var acquired = 0

class Resource {

    init {
        acquired++
    }

    fun close() {
        acquired--
    }

}

suspend fun main() {
    val singleThreadedLauncher = newSingleThreadContext("singleThreadedLauncher")
    coroutineScope {
        repeat(10_000) {
            launch(singleThreadedLauncher) {
                val resource = withTimeout(60) {
                    delay(50)
                    Resource()
                }
                resource.close()
            }
        }
    }
    println("Acquired: $acquired")
}

