package classes.enums

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class IntArithmetics: BinaryOperator<Int>, IntBinaryOperator {

    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },

    MINUS {
        override fun apply(t: Int, u: Int): Int = t - u
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)

}

fun main() {
    val plus = IntArithmetics.PLUS
    val minus = IntArithmetics.MINUS
    println(plus.applyAsInt(10, 99))
    println(minus.applyAsInt(100, 1231))
}