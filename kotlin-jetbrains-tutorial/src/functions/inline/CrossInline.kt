package functions.inline

class CrossInline {

    // Crossinline tells that a lambda cannot use `return` operator
    // to force exit from enclosing function
    private inline fun inlinedFunction(crossinline alpha: () -> Unit, betta: () -> Unit) {
        alpha()
        betta()
        println("CrossInline function executed...")
    }

    fun execute() {
        inlinedFunction(
            {
                println("Alpha lambda function")
            }, {
                println("Betta lambda function")
            })
    }

}

fun main() {

    val crossInline = CrossInline()
    crossInline.execute()

}