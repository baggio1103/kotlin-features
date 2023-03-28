package classes.basics

// Init blocks execute before the constructor, i.e. before object instantiation
class Constructor(name: String) {

    init {
        println("First init block")
    }

    constructor() : this("Default constructor")

    init {
        println("Second init block")
    }

    init {
        println("Third init block")
    }

    init {
        println("Constructor type: $name")
    }

}

class Constructors(i: Int) {
    init {
        println("Init block")
    }

    init {
        println("Constructor $i")
    }
}

fun main() {
    Constructor()
    Constructors(11)
}