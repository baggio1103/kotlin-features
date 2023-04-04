
fun main() {
    val baggio = about {
        generalInfo()
        jobInfo()
    }
}

fun about(run: Person.() -> Unit): Person {
    val person = Person("Baggio", "Kotlin Developer")
    person.run()
    return person
}

class Person(val name: String, val job: String) {


   fun generalInfo() {
        println("My name is $name")
    }

    fun jobInfo() {
        println("I work as a $job")
    }

}