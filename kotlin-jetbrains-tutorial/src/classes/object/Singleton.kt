package classes.`object`

// Singleton pattern in Kotlin is implemented using Object Declarations
// However, using reflection can be created another instance of object UserRegister.
object UserRegister {

    private val list = mutableListOf<String>()

    fun register(user: String) {
        list.add(user)
    }

    fun printAllUsers() {
        list.forEach { println(it) }
    }

}

fun main() {
    val userRegister = UserRegister
    userRegister.register("baggio")
    userRegister.printAllUsers()
}