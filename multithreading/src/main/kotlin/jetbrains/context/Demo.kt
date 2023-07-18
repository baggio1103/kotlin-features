package jetbrains.context

import jetbrains.cancellation.log
import kotlinx.coroutines.*
import org.apache.log4j.Logger

private val log = Logger.getLogger("context-logger")

fun log(message: String) {
    log.info(message)
}

suspend fun main() {

    runBlocking {
        launch {
            log.info("Inside launch")
            delay(100)
            log.info("Shitty")
        }
        log.info("Shit")
    }

    coroutineScope {
        log.info("Shit in coroutine scope")
        launch {
            log.info("Inside launch")
            delay(100)
            log.info("Shitty")
        }
    }

}