package multithreading.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        delay(3000)
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
    println("Main finished execution")
    runBlocking {
        delay(5000L)
    }
}

suspend fun doNetWorkCall(host: String): String {
    delay(2000L)
    println("Network call to $host has been executed in Thread: ${Thread.currentThread().name}")
    return "Network call response from host: $host - Kotlin is the best!!!"
}