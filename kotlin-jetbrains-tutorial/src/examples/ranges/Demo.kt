package examples.ranges

fun main() {
    // Range similar to loops in Java, C++, etc.
    // i in 0..3 == (int i = 0, i <= 3, i++)
    println("Ranges using - x..y operator")
    for (i in 0..3) {
        print("$i ")
    }

    println("\nRanges using - until")
    for (i in 0 until 3) {
        print("$i ")
    }

    println("\nRanges using - step(x) operator")
    for (i in 2..8 step 2) {
        print("$i ")
    }

    println("\nRanges using - downTo operator")
    for (i in 10 downTo 0) {
        print("$i ")
    }

    println("\nRanges using - chars")
    for (i in 'a'..'z') {
        print("$i ")
    }

    println("\nRanges can be useful in 'If' statements")
    val x = 70
    if (x in 10..123) {
        println("Value of x is in range of [10-123]")
    }

    if (x !in 10..55) {
        println("Value of x is not in range of [10-55]")
    }

}