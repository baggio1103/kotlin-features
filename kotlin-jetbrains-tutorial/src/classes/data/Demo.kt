package classes.data

import kotlin.random.Random

// If a parameterless constructor is required, then
// default values must be specified. This is required
// when working with libraries as Jackson or Hibernate
// that work with parameterless constructors of the class

// Data classes generate by default all the useful methods
// - toString(), hashCode(), equals() take into account only fields from the constructor
// if there are properties, then they are not used at the generated methods
data class Student(val name: String = "", val age: Int = 18) {

    val nickName = "$name@${Random.nextInt(10)}"

}

fun main() {

    val baggio = Student("baggio", 23)
    println(baggio)
    println(baggio.nickName)

    // Destructing data classes,
    // only constructor parameters are derived from destruction
    // NickName cannot be derived from destruction
    val (name, age) = Student("wayne", 20)
    println("Name: $name; age: $age")

    // Copying - allows to create a new object copying
    // all the fields of the calling object with a chance to define
    // new values for the fields
    val wayne = baggio.copy(name = "wayne")
    println(wayne)

}