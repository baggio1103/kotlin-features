package functions

/**
 * Var arg functions
 * */
fun <T> asList(vararg values: T): List<T> {
    val result = ArrayList<T>()
    for (value in values) {
        result.add(value)
    }
    return result;
}

// Infix functions are functions that are
// either extension or member functions.
// It can be called either from inside the class
// or object of the same type as specified
// in the function signature
// It has specific function calling syntax
infix fun Int.double(value: Int): Int {
    return 2 * value
}

fun main() {
    // Calling vararg accepting function  - asList
    val asList = asList(1, 2, 3, 4, 5)
    println(asList)

    val array = arrayOf(1, 2, 3, 4, 121, 3)
    val listFromArray = asList(12, 32, *array)
    println(listFromArray)

    val primitiveArray = intArrayOf(3, 123, 12, 312, 3, 12, 3, 21)
    println(asList(*primitiveArray.toTypedArray()))


    // Calling infix functions
    val result = 10 double 2
    println(result)

}
