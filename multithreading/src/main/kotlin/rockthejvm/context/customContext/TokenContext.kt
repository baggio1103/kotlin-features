package rockthejvm.context.customContext

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.CoroutineContext.Key

class TokenContext(val value: String) : CoroutineContext.Element {
    override val key: Key<*>
        get() = token

    companion object {
        val token = object: Key<TokenContext> {

        }
    }

}