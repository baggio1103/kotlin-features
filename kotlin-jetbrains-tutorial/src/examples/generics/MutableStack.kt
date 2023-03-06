package examples.generics

class MutableStack<E>(vararg items: E) {

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString(): String {
        return "MutableList(${elements.joinToString()})"
    }

}

fun <E> mutableStackOf(vararg items: E) = MutableStack(*items)

fun main() {
    val stack = mutableStackOf(0.1, 0.23, 0.11, 0.99)
    println(stack)
}