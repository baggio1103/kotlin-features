package rockthejvm.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import reflectoring.logger
import kotlin.math.log

suspend fun main() {
    logger.info("Starting morning")
    contextOverride()
    logger.info("Finishing morning")
}

suspend fun contextOverride() {
    coroutineScope {
        launch(CoroutineName("Greeting Coroutine")) {
            logger.info("Hello from outer coroutine")
            launch(CoroutineName("Inner Greeting Coroutine")) {
                logger.info("Hello from inner coroutine")
            }
            delay(200)
            logger.info("Bye from outer coroutine")
        }
    }
}