package dsl.server

fun main() {
    val application = application {
        route("/home") {
            get {
                println("Handling GET request for /home")
            }
            post {
                println("Handling POST request for /home")
            }
        }
        route("/about") {
            get {
                println("Handling GET request for /about")
            }
        }
    }
    application.handle("/home", HttpMethod.GET)
    application.handle("/home", HttpMethod.POST)
    application.handle("/about", HttpMethod.GET)
}