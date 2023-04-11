package multithreading.coroutines

import kotlinx.coroutines.*

fun main() {
    val job = GlobalScope.launch(Dispatchers.Default) {
        println("Starting long running calculation")
            for (i in 30 .. 42) {
                val result = fib(i)
                println("Fibonacci result for value - $i = $result." +
                        " Thread: ${Thread.currentThread().name}")
            }
        println("Finishing long running calculation.")
    }
    runBlocking {
        delay(500L)
        job.cancel()
        println("Execution finished. Thread: ${Thread.currentThread().name}")
    }
}

fun fib(n: Int): Int {
   return when (n) {
        0 -> 0
        1 -> 1
        else -> fib(n - 2) + fib(n - 1)
    }
}