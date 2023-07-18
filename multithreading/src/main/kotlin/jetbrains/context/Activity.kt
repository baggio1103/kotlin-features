package jetbrains.context

import kotlinx.coroutines.*

suspend fun main() {
    val activity = Activity()
    activity.doSth()
    log("Launched coroutine to do several jobs")
    delay(500)
    log("Destroying activity")
    activity.destroy()
    delay(2000)
}

class Activity {

    private val scope = CoroutineScope(Dispatchers.Default)

    fun destroy() {
        scope.cancel()
    }

    fun doSth() {
        repeat(10) {
            log("Launched coroutine: $it")
            scope.launch {
                delay((it + 1) * 200L)
                log("Coroutine: $it is done")
            }
        }
    }

}
