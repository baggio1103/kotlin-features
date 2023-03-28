package asynchronous.basics

import kotlinx.coroutines.*

fun main() =  runBlocking {

    val deferredResult: Deferred<Int> = GlobalScope.async {
        delay(500L)
        1231312
    }
    println("Hello world")
    val result = deferredResult.await()
    println(result)
}