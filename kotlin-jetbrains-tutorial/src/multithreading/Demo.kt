package multithreading

import kotlinx.coroutines.*

suspend fun main() {

    GlobalScope.launch {
        delay(1000)
        println("Hello from coroutine that is from Thread: ${Thread.currentThread().name}")
    }
    println("Hello from Thread: ${Thread.currentThread().name}")
    GlobalScope.launch {
        val youtube = doNetWorkCall("youtube")
        println("Request to youtube")
        val google = doNetWorkCall("google")
        println("Request to google")
        println(youtube)
        println(google)
    }
    runBlocking {
        delay(5000L)
    }
}

suspend fun doNetWorkCall(host: String): String {
    delay(2000L)
    return "Network call response from host: $host - Kotlin is the best!!!"
}