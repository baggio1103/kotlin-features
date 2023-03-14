package introduction

fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { it % 2 == 0 }

fun main() {
    println(containsEven(listOf(123,12312,3,12,3,1231)))
}