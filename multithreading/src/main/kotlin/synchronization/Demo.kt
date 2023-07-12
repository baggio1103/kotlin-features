package synchronization

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() {
    val counter = Counter()
    coroutineScope {
        launch {
            for (i in 0 .. 2000) {
                counter.increment()
            }
        }
        launch {
            for (i in 0 .. 100) {
                counter.increment()
            }
        }
    }
    counter.logCounter()
}