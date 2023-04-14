package multithreading.coroutines.exception

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val job = GlobalScope.launch {
       val innerJob = launch {
           try {
               println("Before")
               delay(1000L)
               println("Executing")
           } catch (ex: Exception) {
               println("Inner job has been cancelled")
               ex.printStackTrace()
               throw ex
           }
           println("Finished")
       }
        delay(10)
        innerJob.cancel()
    }

    job.join()
}