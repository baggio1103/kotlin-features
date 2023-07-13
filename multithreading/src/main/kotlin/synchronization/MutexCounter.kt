package synchronization

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.apache.log4j.Logger

class MutexCounter {

    private val mutex = Mutex()

    private var counter = 0

    private val log: Logger = Logger.getLogger(MutexCounter::class.java)

    suspend fun increment() {
        mutex.withLock {
            counter++
        }
    }

    fun counterValue() {
        log.info("Counter value: $counter")
    }

}