package dsl.http

import okhttp3.*


class HttpRequestBuilder {
    var url: String = ""
    var method: HttpMethod = HttpMethod.GET
    private var body: RequestBody? = null
    private val headers = mutableMapOf<String, String>()


    fun header(name: String, value: String) {
        headers[name] = value
    }

    fun applyHeader(block: MutableMap<String, String>.() -> Unit) {
        headers.block()
    }

    fun execute(client: OkHttpClient): Response {
        val requestBuilder = Request.Builder().url(url).method(method.name, body)
        headers.forEach { (name, value) ->
            requestBuilder.addHeader(name, value)
        }
        return client.newCall(requestBuilder.build()).execute()
    }

}



enum class HttpMethod {
    GET,
    POST
}
