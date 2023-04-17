package rockthejvm.context

import kotlinx.coroutines.*
import reflectoring.logger
import kotlin.coroutines.CoroutineContext

suspend fun main() {
    val context: CoroutineContext = CoroutineName("Morning routing") + Dispatchers.Default + Job()
    logger.info(context)
    val newContext: CoroutineContext = context.minusKey(CoroutineName)
    logger.info("CoroutineName: ${context[CoroutineName]?.name}")
    logger.info(newContext)
    asynchronousGreeting()
}

suspend fun asynchronousGreeting() {
    coroutineScope {
        launch(CoroutineName("greeting") + Dispatchers.Default) {
            logger.info("Hello everyone!")
        }
    }
}