package multithreading.coroutines

import kotlinx.coroutines.*

/**
 *  Each coroutine in Kotlin is executed inside a thread.
 *  A thread may have multiple coroutines, and you can set in which Thread a coroutine is executed.
 *  Besides, coroutines can switch their context, i.e. in which Thread they are executed.
 *  A coroutine may start executing in one thread, and then continue execution in another thread
 * */
fun main() {
    val result = GlobalScope.launch(Dispatchers.IO) {
        println("Network call has been made from Thread: ${Thread.currentThread().name}")
        val youtube = doNetWorkCall("youtube")
        withContext(Dispatchers.Default) {
            println("Changing my context to execute in Default Dispatcher")
            delay(2000L)
            println("Network call response has been consumed in Thread: ${Thread.currentThread().name}")
            println(youtube)
        }
        println("Changing context back to IO Dispatcher")
    }
    runBlocking {
        result.join()
    }

}

