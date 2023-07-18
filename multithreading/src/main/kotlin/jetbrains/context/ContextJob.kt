package jetbrains.context

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.job

suspend fun main() {
    coroutineScope {
        log("My job is ${coroutineContext.job}")
        log(coroutineContext[Job].toString())
        log("${coroutineContext.job.isActive}")
    }
}