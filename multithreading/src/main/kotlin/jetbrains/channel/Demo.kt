package jetbrains.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


suspend fun main() {
    val channel = Channel<Int>()
    coroutineScope {
        launch {
            for (x in 1..5) {
                channel.send(x * x)
            }
        }
        repeat(5) {
            log("Received value from channel: ${channel.receive()}")
        }
        log("Channel done")
    }
}