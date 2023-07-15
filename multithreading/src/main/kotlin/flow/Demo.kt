package flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import java.util.*

val random = Random()

suspend fun main() {
    coroutineScope {
        val userFlow = getUsers()
        val userList = getUsersAsList()
        println("Flow: $userFlow")
        println("List: $userList")
    }

}

fun getUsers(): Flow<User> = flow {
    emit(getByIdAndName(
        random.nextInt(1000), "baggio"
    ))
    emit(getByIdAndName(
        random.nextInt(1000), "dave"
    ))
    emit(getByIdAndName(
        random.nextInt(1000), "chris"
    ))
    emit(getByIdAndName(
        random.nextInt(1000), "wayne"
    ))
    emit(getByIdAndName(
        random.nextInt(1000), "tom"
    ))
}

suspend fun getUsersAsList(): List<User> = getUsers().toList()

suspend fun getByIdAndName(id: Int, name: String): User {
    delay(100)
    return User(id, name)
}

