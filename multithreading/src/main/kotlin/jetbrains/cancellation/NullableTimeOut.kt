package jetbrains.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

suspend fun main() {
    val result = withTimeoutOrNull(5000) {
        repeat(100) {
            println("Job: running $it")
            delay(1000)
        }
        "Done"
    }
    result?.let {
       println("Result: $it")
    } ?: run {
        println("Exception happened")
    }
    runBlocking {

    }
}