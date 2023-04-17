package rockthejvm.context.customContext

import kotlinx.coroutines.*
import reflectoring.logger

suspend fun main() {
    val jwtToken = TokenContext("jwt-token")
    val sessionToken = TokenContext("session-token")
    val serverContext = CoroutineName("server") + sessionToken + jwtToken
    coroutineScope {
        launch(serverContext) {
            logger.info("Hello world")
            logger.info(serverContext)
            logger.info(currentCoroutineContext())
            logger.info(currentCoroutineContext()[TokenContext.token]?.value)
        }
    }
}