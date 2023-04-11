package multithreading.coroutines.async

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val job = GlobalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            val universities = universities()
            val students = students()
            universities.let { uni ->
                println("Universities:")
                uni.forEach { print("$it ") }
                println()
            }
            students.let { stu ->
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

suspend fun universities(): List<String> {
    withContext(Dispatchers.IO) {
        Thread.sleep(3000)
    }
    return listOf("MIPT", "INNOPOLIS", "KFU")
}

suspend fun students(): List<String> {
    withContext(Dispatchers.IO) {
        Thread.sleep(2000)
    }
    return listOf("WAYNE", "BRUCE", "BAGGIO")
}