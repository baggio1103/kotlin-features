package jetbrains.suspending

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main() {
    try {
        computeExceptionally()
    } catch (ex: ArithmeticException) {
        println("Arithmetic exception happened")
    }

}

suspend fun computeExceptionally(): Int {
    return coroutineScope {
        val resultOne = async {
            try {
                delay(5000)
                5000
            } finally {
                println("Coroutine two is being cancelled")
            }
        }
        val resultTwo = async<Int> {
            try {
                println("Second coroutine is failing")
                throw ArithmeticException()
            } finally {
                println("Exception happened")
            }
        }
        resultOne.await() + resultTwo.await()
    }

}