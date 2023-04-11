package multithreading.coroutines.async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

suspend fun main() {

    val job = GlobalScope.launch {
        val async = async {
            universities()
        }
        println("Send request to universities")
        async.invokeOnCompletion {
            println("Request executed")
        }
        val universities = async.await()
        println(universities)
    }
    job.join()

}