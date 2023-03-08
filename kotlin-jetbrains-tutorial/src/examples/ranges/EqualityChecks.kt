package examples.ranges

fun main() {
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")
    // Reference by structure
    println(authors == writers)

    //Reference by referential comparison
    println(authors === writers)
}