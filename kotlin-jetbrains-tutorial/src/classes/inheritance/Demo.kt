package classes.inheritance

class Html {

    fun body() {
        println("Rendering body")
    }

    fun header() {
        println("Rendering header")
    }

}

fun html(run: Html.() -> Unit) {
    val html = Html()
    html.run()
}

fun main() {

    html {
        body()
        header()
    }

}