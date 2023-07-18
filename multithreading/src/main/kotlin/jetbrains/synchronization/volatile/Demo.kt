package jetbrains.synchronization.volatile

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

suspend fun main() {
    val shop = Shop()

    val threadOne = thread {
        runBlocking {
            shop.sell()
        }
    }
//    delay(1000)
    shop.isOpen = true
//    val threadTwo = thread {
//        runBlocking {
//            shop.sell()
//        }
//    }
    threadOne.join()
//    threadTwo.join()
}