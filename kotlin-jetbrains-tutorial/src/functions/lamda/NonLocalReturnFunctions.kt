package functions.lamda

fun <T, R> lambdaFunction(value: T, block: (T) -> R): R {
    return block(value)
}

// Non Local Returns
// To return from a lambda, using return keyword is not enough
// it is needed to use a label as well, i.e. the name of the lambda
// as shown in the example below
fun <T> function(value: T) {
    val lambdaFunctionValue = lambdaFunction(value) {
        when (it) {
            is Int -> {
                if (11 in 0..it) return@lambdaFunction 12312312
            }
        }
        value
    }
    println(lambdaFunctionValue)
}

fun main() {
    function("Some function")
    function(2)
}

