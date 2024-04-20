package dsl.http

import okhttp3.OkHttpClient
import okhttp3.Response

fun http(block: HttpRequestBuilder.() -> Unit): Response {
    val builder = HttpRequestBuilder()
    builder.block()
    val client = OkHttpClient()
    return builder.execute(client)
}