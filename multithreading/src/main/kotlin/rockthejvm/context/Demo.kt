package rockthejvm.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.newCoroutineContext
import reflectoring.logger
import kotlin.coroutines.coroutineContext
import kotlin.math.log

@OptIn(InternalCoroutinesApi::class)
suspend fun main() {
    val jvm = CoroutineName("rockthejvm")
    logger.info(jvm.name)
    logger.info(jvm.key)
    val context = coroutineContext.plus(jvm)
    val key = coroutineContext[jvm.key]
    currentCoroutineContext().plus(jvm)
    currentCoroutineContext().newCoroutineContext(jvm)
    logger.info(key?.key)
    logger.info(coroutineContext[jvm.key])
    logger.info(context[jvm.key].toString().plus( " dasf"))
    logger.info(currentCoroutineContext()[jvm.key])
    when (key) {
        is CoroutineName -> logger.info(key.name)
        else -> logger.info("shit")
    }
}

