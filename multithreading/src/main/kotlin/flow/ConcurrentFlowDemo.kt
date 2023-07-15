package flow

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlin.system.measureTimeMillis

suspend fun main() {
    val sequentialExecTime = measureTimeMillis {
        coroutineScope {
            val userFlow = getUsers()
            userFlow.collect {
                    user -> println("Username: ${user.name}")
                delay(500)
            }
        }
    }
    println("Sequential exec time: $sequentialExecTime")

    /**
     * Flow.buffer() - adds concurrency to flow,
     * then collect() runs on its own coroutine
     * and emit() runs on its owns coroutine
     * */
    val concurrentExecTime = measureTimeMillis {
        coroutineScope {
            val userFlow = getUsers()
            userFlow.buffer(10, BufferOverflow.SUSPEND).collect {
                    user -> println("Username: ${user.name}")
                delay(500)
            }
        }
    }
    println("Concurrent exec time: $concurrentExecTime")
}