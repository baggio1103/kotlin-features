package functions

import kotlinx.coroutines.delay

suspend fun main() {
    postItem("Posting item")
}

suspend fun requestTokenAsync(block: (Token) -> Unit) {
    println("Requesting token async...")
    delay(10)
    println("Token received...")
    block(Token("qwerty"))
}

fun createPostAsync(token: Token, message: String, block: (Post) -> Unit) {
    println("Creating post: $token, message: $message")
    block(Post("https://java-jedi.medium.com/"))
}

fun processPost(post: Post) {
    println("Processing post: $post")
}

suspend fun postItem(message: String) {
    requestTokenAsync { token ->
        println("Token: $token. Message: $message")
        createPostAsync(token, message) { post ->
            processPost(post)
        }
    }
}

data class Post(val url: String)

data class Token(val token: String)