package functions.lamda

// Function type with lambda expression
val max = { strings: List<String>, function: (a: String, b: String) -> String ->
    var result = ""
    strings.forEach {
        result = function(result, it)
    }
    result
}

// Anonymous Functions are just like lambda functions
// that can be passed as function arguments
// The difference from ordinary functions is that
// Anonymous Functions have no name
// A function type that filters incoming list by using anonymous Function
// ! Anonymous function must be places inside parentheses
// Putting function inside curly braces works only for Lambdas
val filterList = { strings: List<String> ->
    strings.filter(fun(value: String): Boolean {
         return value.length > 5
    })
}


fun main() {

    val numbers = listOf(1, 2, 21, 322)
    val list = numbers.filter {
        return@filter it > 0
    }
    println(list)


    val words = listOf("computer science", "love", "coding")
    println(max(words) { a: String, b: String ->
        if (a.length > b.length) a else b
    }
    )

    val filteredWords = filterList(words)
    println(filteredWords)


    filterList.invoke(words)

}