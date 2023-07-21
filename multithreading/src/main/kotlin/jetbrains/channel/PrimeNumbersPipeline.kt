package jetbrains.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

suspend fun main() {
    coroutineScope {
        val primeNumberJob = launch {
        val numbers = produceNumbers(2)
        val primeNumbers = filter(numbers, 2)
            for (x in primeNumbers) {
                println("Number: $x")
            }
        }
        delay(5000)
        primeNumberJob.cancelAndJoin()
    }
}

fun CoroutineScope.produceNumbers(start: Int): ReceiveChannel<Int> = produce {
    var x = start
    while (true) {
        send(x++)
        delay(100)
    }
}

fun CoroutineScope.filter(channel: ReceiveChannel<Int>, prime: Int): ReceiveChannel<Int> = produce {
    for (x in channel) {
        if (x % prime != 0) {
            send(x)
        }
    }
}

