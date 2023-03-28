package asynchronous.basics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

fun main() {
    CoroutineScope(Dispatchers.Main + Job())

    val runnable = {
        Thread.sleep(3000)
        println("Hello world")
    }

    val thread = Thread(runnable)
    println(thread.isDaemon)
    thread.isDaemon = true
    println(thread.isDaemon)
    thread.start()
    println(thread.isDaemon)

    val threadTwo = Thread {
        println("shiiit")
    }
    threadTwo.start()
}
