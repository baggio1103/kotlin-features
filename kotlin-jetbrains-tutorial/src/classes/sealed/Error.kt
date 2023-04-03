package classes.sealed

import java.io.File

sealed interface Error

sealed class IOError: Error {

    constructor()

    private constructor(description: String) {
        println("Description: $description")
    }

}

class FileReadError(val file: File): IOError()

class FileWriteError(val file: File): IOError()

object RuntimeError: Error

//The key benefit of using sealed classes comes into play
// when you use them in a when expression. If it's possible
// to verify that the statement covers all cases, you don't
// need to add an else clause to the statement:
fun main() {
    val error = RuntimeError
    println(defineError(error))
    println(defineError(FileReadError(File("text.txt"))))
    println(defineError(FileWriteError(File("text.txt"))))
}

fun defineError(error: Error): String {
    return when (error) {
        is FileReadError -> "It is a FileReadError"
        is FileWriteError -> "It is a FileWriteError"
        RuntimeError -> "It is a RuntimeError"
    }
}