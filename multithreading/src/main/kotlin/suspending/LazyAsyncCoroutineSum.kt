package suspending

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.system.measureTimeMillis

/**
 * async(start = CoroutineStart.LAZY) - declares a lazy coroutine
 * start() - starts a coroutine if not started yet
 * if coroutine is not started, and it is lazy,
 * then calling await() without start() will make them sequential
 * To achieve concurrency, you need  to start them and call await()
 * when needed
 * */

suspend fun main() {
    val execTime = measureTimeMillis {
        coroutineScope {
            val resultOne = async(start = CoroutineStart.LAZY) {
                doComputationOne()
            }
            val resultTwo = async(start = CoroutineStart.LAZY) {
                doComputationTwo()
            }
            println(
                resultOne.start()
            )
            println(
                resultOne.start()
            )

            resultTwo.start()
            println("Sum: ${resultOne.await() + resultTwo.await()}")
        }
    }
    println("Exec time: $execTime")
}