package multithreading.coroutines

import kotlinx.coroutines.*

/**
 *  runBlocking is used to call a suspend function from a thread.
 *  In this case, a thread is blocked until the execution of runBlocking block.
 *  Inside runBlocking, you can start several coroutines (with different context)
 *  and all these coroutines will be asynchronous.
 *
 */
fun main() {
    println("Before Run Blocking")
    runBlocking {
        launch(Dispatchers.IO) {
            delay(1000)
            println("Coroutine One inside runBlocking Thread: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            delay(1000)
            println("Coroutine Two inside runBlocking Thread: ${Thread.currentThread().name}")
        }
        println("Start of Run Blocking. Thread: ${Thread.currentThread().name}")
        delay(30)
        println("End of Run Blocking. Thread: ${Thread.currentThread().name}")
    }
    println("After Run Blocking")
}