package multithreading.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *  Coroutine launches a job. A job can be canceled or waited.
 *  job.join() - A thread will wait until the coroutine finishes execution
 * */
fun main() {
    val job = GlobalScope.launch {
        repeat(5) {
            println("Coroutine is still working")
            delay(1000)
        }
        println("Coroutine has finished executing")
    }
    runBlocking {
        job.join()
        println("Main Thread is continuing")
    }
    println("Exiting...")
}