package functions.lamda

fun <T, R> lambdaFunction(value: T, block: (T) -> R): R {
    return block(value)
}

//Non Local Returns
// To return from a lambda, using return keyword is not enough
// it is needed to use a label as well, i.e. the name of the lambda
// as shown in the example below
fun <T> function(value: T) {
    val lambdaFunction = lambdaFunction(value) {
        when (value) {
            is Int -> {
                for (i in 0..value) {
                    if (i == 11) {
                        return@lambdaFunction 1231231231
                    }
                }
            }
            else -> return@lambdaFunction "Unknown type"
        }
    }
    println(lambdaFunction)
}

fun main() {
    function("Some function")
    function(20)
}

