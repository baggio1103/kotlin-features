package jetbrains.channel.fan

import jetbrains.channel.log
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun sendString(channel: SendChannel<String>, string: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(string)
    }
}

suspend fun main() {
    coroutineScope {
        val channel = Channel<String>()
        launch {
            sendString(channel, "Kotlin", 200)
        }
        launch {
            sendString(channel, "Java", 300)
        }
        repeat(10) {
            log(channel.receive())
        }
        coroutineContext.cancelChildren()
    }
}