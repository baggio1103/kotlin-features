package functions.lamda


fun stringLength(string: String) = string.length

fun getString(): String? = "hello"

fun main() {
    var number: Int? = null
    number = 2312
    println(number)

    var inferredNonNull = "Non null variable"
    inferredNonNull = null.toString()
    println(inferredNonNull)

    var nullableString: String? = null
    nullableString = null
    println(nullableString)
    nullableString = "Nullable string"
    println(nullableString)
    println(stringLength(nullableString))
    val string = getString()
}
