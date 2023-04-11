package multithreading.coroutines.async

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 *  Inside a coroutines, suspend methods are executed sequentially.
 *  However, to execute methods synchronously, we need to use async { }
 *  that starts a new coroutine and takes a method as an argument.
 *  async {} -> Deferred<T>
 * */
fun main() {
    val job = GlobalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            val universities = async { universities() }
            val students = async { students() }
            universities.await().let { uni ->
                println("Universities:")
                uni.forEach { print("$it ") }
                println()
            }
            students.await().let { stu ->
                println("Students:")
                stu.forEach { print("$it ") }
                println()
            }
        }
        println("Time for execution took $time ms")
    }
    runBlocking {
        job.join()
    }
}
