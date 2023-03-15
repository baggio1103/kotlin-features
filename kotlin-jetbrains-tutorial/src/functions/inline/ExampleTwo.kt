package functions.inline

import java.util.*

val random = Random()

// if function is not inline, then it is impossible to use return operator
// from passed lambda to exit from outer function, e.g. - highOrderFunction
// Using return operator results in compile error
fun highOrderFunction(alpha: () -> Unit, betta: () -> Unit) {
    alpha()
    betta()
}


// Using inline keyword enables to use return operator
// from passed lambda to exit from outer function, e.g. - highOrderFunction
// In this case, if alpha() has a return statement, then betta() will not execute.
// Inside inline function if passed lambdas have return statements, then return propagates
// to outer function too
inline fun inlineAbleHighOrderFunction(alpha: () -> Unit, betta: () -> Unit) {
    alpha()
    betta()
}

fun random() = random.nextInt()

fun main() {
    highOrderFunction(
        alpha = {
            println("Alpha function")
            val randomValue = random()
            if (randomValue % 2 == 0) {
                println("RandomValue: $randomValue is even")
                return@highOrderFunction
            } else {
                println("RandomValue $randomValue is not even")
            }
            println("Alpha function executed")
        }, betta = {
            println("Betta function")
        }
    )
    println("====================================")
    inlineAbleHighOrderFunction(
        alpha = {
            val randomValue = random()
            if (randomValue % 2 == 0) {
                println("RandomValue: $randomValue")
                return
            } else {
                println("Random number $randomValue is not even")
            }
            println("Alpha function")
        }, betta = {
            println("Betta function")
        }
    )
    println("====================================")
}