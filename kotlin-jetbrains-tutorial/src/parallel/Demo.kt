package parallel

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.awaitAll

suspend fun <A, B> Iterable<A>.map(function: suspend (A) -> B): List<B> = coroutineScope {
    map { async { function(it) } }.awaitAll()
}

fun main(args: Array<String>) = runBlocking(Dispatchers.Default) {
    val time = measureTimeMillis {
        val output = (1..100).pmap {
            delay(1000)
            it * 2
        }

        println(output)
    }

    println("Total time: $time")
}