package suspending

import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

suspend fun main() {
    val time = measureTimeMillis {
        val resultOne = doComputationOne()
        val resultTwo = doComputationTwo()
        println("Result: ${resultOne + resultTwo}")
    }
    println("Exec time: $time")
}

suspend fun doComputationOne(): Int {
    delay(1000)
    return 159
}

suspend fun doComputationTwo(): Int {
    delay(1000)
    return 159
}