package multithreading.coroutines.async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val async = GlobalScope.async {
        println("Send request to universities")
        universities()
    }
    println("Main continues execution")
    GlobalScope.launch {
        async.await().forEach {
            println("$it H2 ${Thread.currentThread().name}")
        }
    }
    val universities = async.await()
    universities.forEach {
        println("$it H1 ${Thread.currentThread().name}")
    }
}