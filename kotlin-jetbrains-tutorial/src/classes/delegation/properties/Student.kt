package classes.delegation.properties

class Student(map: Map<String, Any?>) {

    val username: String by map

    val faculty: String by map

}

fun main() {
    val map = mapOf(
        "username" to "Wayne",
        "faculty" to "competitive programming"
        )
    val student = Student(map)
    println(student.username)
    println(student.faculty)
}