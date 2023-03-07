package examples.inheritance

open class Dog {

    open fun sayHello() {
        println("Wow wow")
    }

}

class YorkShire(): Dog() {

    override fun sayHello() {
        println("Wif wif")
    }

}


open class Tiger(private val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger: Tiger("Siberia")



open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India")

fun main() {
    val dog = Dog()
    dog.sayHello()
    val yorkShire = YorkShire()
    yorkShire.sayHello()
    println("Classes with parameterized constructor")
    val siberianTiger = SiberianTiger()
    siberianTiger.sayHello()

    println("Classes with parameterized constructor")
    val lion: Lion = Asiatic("Rufo")                              // 2
    lion.sayHello()
}