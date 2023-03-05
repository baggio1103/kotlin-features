package functions.lamda

class Html {

    fun body() {
        println("Shit")
    }

}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}

fun main() {

    val html = html {
        body()
    }
    html.body()

}