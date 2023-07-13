package synchronization

import kotlin.concurrent.thread

fun main() {
    val counter = Counter()
    val threadOne = thread {
        for (i in 0 until  10_000) {
            counter.increment()
        }
    }
    val threadTwo = thread {
        for (i in 0 until 10_000) {
            counter.increment()
        }
    }
    threadOne.join()
    threadTwo.join()
    counter.logCounter()
}