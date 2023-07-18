package jetbrains.context

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext

suspend fun main() {
    newSingleThreadContext("context-one").use { contextOne ->
        newSingleThreadContext("context-two").use { contextTwo ->
            coroutineScope {
                launch(contextOne) {
                    log("Started inside context one")
                    withContext(contextTwo) {
                        log("But executing inside context two")
                    }
                    log("Back to work in context one")
                }
            }
        }
    }
}