package asynchronous.basics

import kotlinx.coroutines.*

fun main() {
    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
        ioOperation()
        println("shiiiit ioOperation")
    }
    println("Helll")
    runBlocking {
        delay(1000L)
        println("First Coroutine")
    }
    runBlocking {
        delay(1000L)
        println("Second Coroutine")
    }
    runBlocking {
        delay(1000L)
        println("Third Coroutine")
    }
    println("Print Order")
}

suspend fun ioOperation() {
    delay(1000)
    println("IO operations are being executed...")
}