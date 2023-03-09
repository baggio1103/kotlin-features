package examples.classes

data class User(val name: String, val id: Int) {

    override fun equals(other: Any?): Boolean {
        return other is User && other.id == this.id
    }

}

fun main() {

    val user = User("Alex", 1)
    println(user)
    val secondUser = User("Max", 1)
    val thirdUser = User("Wayne", 2)
    println("User == secondUser by content? ${user == secondUser}")
    println("User == secondUser by reference? ${user === secondUser}")
    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())
    println(user.copy(name = "Max"))
    println(user.copy(id = 11))
    println("User name: ${user.component1()}")
    println("User id: ${user.component2()}")
}