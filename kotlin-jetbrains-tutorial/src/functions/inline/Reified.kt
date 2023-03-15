package functions.inline

class Reified {

    private inline fun <reified T> reifiedFunction() {
        println(T::class)
    }

    fun execute() {
        reifiedFunction<String>()
    }

}

fun main() {
    val reified = Reified()
    reified.execute()
}