package jetbrains.context

import kotlinx.coroutines.*

val threadLocal = ThreadLocal<String>()

suspend fun main() {
    runBlocking {
        threadLocal.set("main")
        log("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        val job = launch(Dispatchers.Default + threadLocal.asContextElement("launcher")) {
            log("Launch start current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
            yield()
            log("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        }
        job.join()
        log("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    }
}