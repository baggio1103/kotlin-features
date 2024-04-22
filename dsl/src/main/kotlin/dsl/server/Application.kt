package dsl.server

class Application {

    private val routes = mutableMapOf<String, Route>()

    fun route(path: String, block: Route.() -> Unit) {
        val route = Route().apply(block)
        routes[path] = route
    }

    fun handle(path: String, method: HttpMethod) {
        val route = routes[path]
        route?.handle(method)
    }

}

class Route {

    private val handlers = mutableMapOf<HttpMethod, () -> Unit>()

    fun get(handler: () -> Unit) {
        handlers[HttpMethod.GET] = handler
    }

    fun post(handler: () -> Unit) {
        handlers[HttpMethod.POST] = handler
    }

    fun handle(method: HttpMethod) {
        val handler = handlers[method]
        handler?.invoke() ?: println("No handler found for method: $method")
    }

}

enum class HttpMethod {
    GET,
    POST
}

fun application(block: Application.() -> Unit): Application {
    return Application().apply(block)
}