import java.util.*

fun main() {
    println(
        value("afsd")
    )
    val decode = Base64.getMimeEncoder().encodeToString("Hello".toByteArray())
    println(decode)
    println(Base64.getMimeDecoder().decode("SGVsbG8=").toString())
    val result = "${Helper.onEmptyConstant} ${Helper.onEmptyConstant} ${Helper.onEmptyConstant}"
    println(result)
    println("- - -" == result)
}

class Helper {
    companion object {
        const val onEmptyConstant = "-"
    }
}

fun <T> value(value: T): T {
   return try {
        value
    } finally {
        println("Hello world")
    }
}