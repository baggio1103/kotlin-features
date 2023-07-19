package jetbrains.channel

import org.apache.log4j.Logger

private val log: Logger = Logger.getLogger("channel")

fun log(message: String) {
    log.info(message)
}