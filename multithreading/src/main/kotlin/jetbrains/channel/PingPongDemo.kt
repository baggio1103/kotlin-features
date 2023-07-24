package jetbrains.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

data class Ball(var hits: Int)

suspend fun main() {

    coroutineScope {
        val table: Channel<Ball> = Channel()
        launch {
            player("ping", table)
        }
        launch {
            player("pong", table)
        }
        table.send(Ball(0))
        delay(5000)
        coroutineContext.cancelChildren()
    }

}

suspend fun player(name: String, table: Channel<Ball>) {
    for (ball in table) {
        ball.hits++
        log("$name, $ball")
        delay(300)
        table.send(ball)
    }
}