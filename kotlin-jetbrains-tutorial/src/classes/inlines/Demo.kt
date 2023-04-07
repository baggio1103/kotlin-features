package classes.inlines


@JvmInline
value class Password(val value: String)

fun main() {
    // No actual instantiation of class 'Password' happens
    // At runtime 'securePassword' contains just 'String'
    val securePassword = Password("qwerty")
    println(securePassword)
}