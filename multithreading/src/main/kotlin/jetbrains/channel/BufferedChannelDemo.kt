package jetbrains.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


suspend fun main() {

    coroutineScope {
        val channel = Channel<Int>(5)
        val sender = launch {
            repeat(10) {
                log("Sending value: ${(it + 1) * (it + 1)}")
                channel.send((it + 1) * (it + 1))
            }
        }
        delay(1000)
        sender.cancel()
    }

}