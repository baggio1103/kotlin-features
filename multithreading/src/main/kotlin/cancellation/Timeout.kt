package cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout

suspend fun main() {
    withTimeout(3000) {
        repeat(10) {
            println("Job: running $it time")
            delay(500)
        }
    }
    println("Waiting...")
}