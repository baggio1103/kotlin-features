package functions.inline

import java.util.*

class NoInline {

    private val random = Random().nextInt()

    private inline fun inlinedFunction(noinline alpha: () -> Unit, betta: () -> Unit) {
        alpha()
        betta()
        println("NoInline function executed...")
    }

    fun execute() {
        inlinedFunction(
            {
                if (random % 2 == 0) {
                    println("RandomValue $random is even. Alpha lambda")
                    return@inlinedFunction
                }
                println("RandomValue $random is odd")
                println("Alpha lambda function finished execution")
            }, {
                if (random % 2 == 0) {
                    println("RandomValue $random is even. Betta lambda \nBetta lambda force exit from lambda and enclosing function")
                    return
                }
                println("RandomValue $random is odd")
                println("Betta lambda function finished execution")
            })
    }

}

fun main() {

    val noInline = NoInline()
    noInline.execute()

}