package functions.inline

import java.util.*

class ExampleThree {

    private val random = Random().nextInt()
    // IF inline function has a lambda with return operator, then it will force to quit
    // outer function too. callerFunction() calls inlineAbleHighOrderFunction() with
    // alpha lambda that has a lambda argument return@FunctionName and return.
    // If return is called from alpha(), then it will exit inlineAbleHighOrderFunction() and callerFunction() too
    private inline fun inlineAbleHighOrderFunction(alpha: () -> String, betta: () -> Unit): String {
        alpha()
        betta()
        return "Exiting from inlineAbleHighOrderFunction"
    }

    fun callerFunction(): String {
        val result = inlineAbleHighOrderFunction(
            alpha =  {
                if (random % 2 == 0) {
                    return "Random value $random is even; Force Exiting from caller function"
                }
                println("Random value $random is not event")
                "Returning from alpha lambda"
            },
            {
                println(
                    "Betta function"
                )
            }
        )
        println("Result of inlineAbleHighOrderFunction() is $result")
        return "Caller function"
    }

}

fun main() {
    val exampleThree = ExampleThree()
    val value = exampleThree.callerFunction()
    println(value)
    println("Main function has executed")

}