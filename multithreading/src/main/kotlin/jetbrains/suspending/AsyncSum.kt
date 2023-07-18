package jetbrains.suspending

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.system.measureTimeMillis

suspend fun main() {
    val execTime = measureTimeMillis {
        coroutineScope {
            val resultOne = async {
                doComputationOne()
            }
            val resultTwo = async {
                doComputationTwo()
            }
            println("Result: ${resultOne.await() + resultTwo.await()}")
        }
    }
    println("Exec time: $execTime")
}