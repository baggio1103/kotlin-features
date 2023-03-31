package classes.basics

class Person(val name: String, val pets: MutableList<Pet> = mutableListOf()) {
    override fun toString(): String {
        return "Person: $name, pets: $pets"
    }

}

class Pet(private val name: String, private val owner: Person) {

    init {
        owner.pets.add(this)
        println("Adding current pet $name to person: ${owner.name}")
    }

    override fun toString(): String {
        return "Pet: $name"
    }

}

fun main() {
    val person = Person("baggio")
    val richie = Pet("richie", person)
    println(person)
    println(richie)
}