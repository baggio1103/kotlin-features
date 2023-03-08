package examples.ranges


fun maxOfTwo(x: Int, y: Int) = if (x > y) x else y

fun main() {
    //In Kotlin, there is no a ternary operator,
    //Instead, we can use if expressions.
    print("Max of 21332 and 12312 is - ${maxOfTwo(21332, 12312)}")
}