package reflectoring.dispatchers.defaults

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import reflectoring.netWorkCall

/**
 * In this thread, we are dedicating a single thread
 * that will be responsible handling all the coroutines
 * */
val threadContext = newSingleThreadContext("networkThread")
fun main() = runBlocking {
    repeat(100) {
        launch(threadContext) {
            netWorkCall()
        }
    }
    threadContext.close()
    println("Network call has been executed")
}