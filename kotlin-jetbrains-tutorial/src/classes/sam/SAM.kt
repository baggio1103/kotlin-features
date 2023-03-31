package classes.sam

//An interface with only one abstract method is called a functional interface,
// or a Single Abstract Method (SAM) interface. The functional interface can
// have several non-abstract members but only one abstract member.
interface KRunnable {

    fun run()

}

// To point that an interface is a functional interface
// mark interface with a modifier - `fun`
fun interface KCallable<T> {
    fun call(): T

}


fun main() {

    // Instantiating a KRunnable interface.
    // object:InterfaceName keyword is used to create an instance
    // that implements an interface.
    // This is called anonymous object
    val runnable = object: KRunnable {
        override fun run() {
            println("Running")
        }
    }
    runnable.run()

    val callable = KCallable {
        "This is a return value of KCallable interface"
    }
    println(callable.call())

}