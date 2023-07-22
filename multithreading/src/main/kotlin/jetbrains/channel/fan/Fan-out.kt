package jetbrains.channel.fan

import jetbrains.channel.log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>)  {
    launch {
        for (msg in channel) {
            log("Processor with id: $id received message: $msg")
        }
    }
}

suspend fun main() {
    runBlocking {
        val produceNumbers = produceNumbers()
        repeat(10) {
            launchProcessor(it, produceNumbers)
        }
        delay(5000)
        produceNumbers.cancel()
    }
}