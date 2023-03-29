package classes.basics

// Init blocks execute before the constructor, i.e. before object instantiation
class Constructor(name: String) {

    init {
        println("First init block")
    }

    constructor() : this("Default constructor") {
        println("Initializing a default constructor")
    }

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
    Constructor("Primary constructor")
    println("-------------------------------------------")
    Constructor()
    println("-------------------------------------------")
    Constructors(11)
}