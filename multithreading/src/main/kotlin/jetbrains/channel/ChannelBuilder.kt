package jetbrains.channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) {
        send(x * x)
    }
}

suspend fun main() {
    coroutineScope {
        val squares = produceSquares()
        squares.consumeEach {
            log("Consuming value from channel: $it")
        }
    }
}