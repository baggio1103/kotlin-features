package dsl.http

fun main() {
    val response = http {
        url = "https://jsonplaceholder.typicode.com/posts/1"
        method = HttpMethod.GET
        header("Accept", "application/json")
        applyHeader {
            this["token"] = "Bearer"
        }
    }
    println("ResponseBody: ${response.body?.string()}")
}