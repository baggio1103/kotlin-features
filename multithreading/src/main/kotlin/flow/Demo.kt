package flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlin.random.Random

val random = Random(10)

suspend fun main() {

    coroutineScope {
        val users = getUsers()
        println(
            users.map { it.name }
        )
    }

}

fun getUsers(): Flow<User> = flow {
    emit(getByIdAndName(
        random.nextInt(), "baggio"
    ))
}

suspend fun getByIdAndName(id: Int, name: String): User {
    delay(100)
    return User(id, name)
}

