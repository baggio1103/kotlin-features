package multithreading.coroutines.exception

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val job = GlobalScope.launch {
       val innerJob = launch {
           try {
               delay(1000L)
               println("Executing")
           } catch (ex: Exception) {
               println("Inner job has been cancelled")
               throw ex
               ex.printStackTrace()
           }
           println("Finished")
       }
        delay(300)
        innerJob.cancel()
    }

    job.join()
}