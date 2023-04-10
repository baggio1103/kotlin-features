package multithreading.coroutines

import kotlinx.coroutines.*


fun main() {
   val result = GlobalScope.launch(Dispatchers.IO) {
       println("Network call has been executed in Thread: ${Thread.currentThread().name}")
       val youtube = doNetWorkCall("youtube")
       withContext(Dispatchers.Default) {
           delay(2000L)
           println("Network call response has been consumed in Thread: ${Thread.currentThread().name}")
           println(youtube)
       }
       println("Changing my context")
    }
    runBlocking {
        result.join()
    }
}

