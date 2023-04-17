package rockthejvm.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import reflectoring.logger

suspend fun main() {
    contextInheritance()
}

suspend fun contextInheritance() {
    coroutineScope {
        launch(CoroutineName("Greeting Coroutine")) {
            logger.info("Hello everyone from outer coroutine!")
            launch {
                logger.info("Hello everyone from inner coroutine")
            }
            delay(200)
            logger.info("Bye bye from outer coroutine")
        }
    }
}