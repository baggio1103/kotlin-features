package classes.basics

class Person(val name: String, val pets: MutableList<Pet> = mutableListOf()) {
    override fun toString(): String {
        return "Pets: $pets"
    }

}

class Pet(name: String, owner: Person) {

    init {
        owner.pets.add(this)
        println("Adding current pet $name to person: ${owner.name}")
    }

}

fun main() {
    val person = Person("baggio")
    val richie = Pet("richie", person)
}