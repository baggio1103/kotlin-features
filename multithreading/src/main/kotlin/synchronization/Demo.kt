package synchronization

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val counter = Counter()
    coroutineScope {
        launch {
            delay(200)
            for (i in 0 until  2000) {
                counter.increment()
            }
        }
        println("First coroutine started execution")
        launch {
            delay(200)
            for (i in 0 until  100) {
                counter.increment()
            }
        }
        println("Second coroutine started its execution")
    }
    counter.logCounter()
}