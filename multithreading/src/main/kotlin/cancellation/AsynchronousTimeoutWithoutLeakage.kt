package cancellation

import kotlinx.coroutines.*

suspend fun main() {
    val launcher = newSingleThreadContext("launcher")
    coroutineScope {
        repeat(10_000) {
            launch(launcher) {
                var resource: Resource? = null
                try {
                    withTimeout(60) {
                        delay(50)
                        resource = Resource() // acquired
                    }
                } finally {
                    // Here exception might have occurred, hence to avoid leakage, close the resource
                    resource?.close()
                }
            }
        }
    }
    println("Acquired: $acquired")
}