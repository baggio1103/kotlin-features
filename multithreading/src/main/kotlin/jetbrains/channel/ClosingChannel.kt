package jetbrains.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    coroutineScope {
        val channel = Channel<Int>()
        launch {
            for (x in 1..5) {
                channel.send(x * x)
                log("Sending to channel")
            }
            channel.close()
        }
        launch {
            for (y in channel) {
                delay(100)
                log("Receiving from channel - $y")
            }
        }
    }
}