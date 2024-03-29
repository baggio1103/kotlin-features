package classes.interfaces

interface Named {

    val name: String

}

interface Person: Named {

    val firstName: String

    val lastName: String
    override val name: String
        get() = "$firstName $lastName"

}

data class Employee(override val firstName: String, override val lastName: String): Person

fun main() {
    val person = Employee("Bruce", "Wayne")
    println(person)
}