package functions.lamda

// High order functions
fun <T, R> Collection<T>.fold(initial: R,
    combine: (accumulator: R, currentValue: T) -> R): R {
    var accumulator: R = initial
    forEach {
        accumulator = combine(accumulator, it)
    }
    return accumulator
}


// Function Types - are declarations that deal with functions,
// i.e a function assigned to a variable that acts as an usual function
val calculator = { a: Int, b: Int, function: (x: Int, y: Int) -> Int  ->
    function(a, b)
}


// Function types with Receiver
// Receiver refers to the type that invokes this method
// in this example, String type is the receiver
// This function type repeatWord can be invoked
// by String type objects only
val repeatWord : String.(Int) -> String = { times ->
    repeat(times)
}


// A function type with no explicit return type
val implicitRepeatFunction = { a: String, b: Int -> Int
    a.repeat(b)
}

// A function type with implicit return type
val explicitRepeatFunction: (String, Int) -> String = {
    a, b -> a.repeat(b)
}

fun main() {

    // High order functions
    val items = listOf(1, 2, 3, 4, 5)
    val sum = items.fold(0) { accumulator: Int, currentValue: Int ->
        println("Acc: $accumulator, currentValue: $currentValue")
        accumulator + currentValue
    }
    println("Result of fold function: $sum")


    // Function Types
    println("====== Function types ======")
    val add = {
        a: Int, b: Int -> a + b
    }
    val calculatorResult = calculator(1, 2, add)
    println("Result of calculator function type: $calculatorResult")

    // Function type with Receiver
    val text = "Coding-> ".repeatWord(10)
    println(text)

    // Function type with no receiver
    val repeatedText = implicitRepeatFunction("Kotlin ", 12)
    println(repeatedText)

    val repeatedText2 = explicitRepeatFunction("Kotlin ", 12)
    println(repeatedText2)

}
