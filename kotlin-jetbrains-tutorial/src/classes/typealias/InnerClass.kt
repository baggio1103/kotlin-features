package classes.`typealias`

class A {

    inner class Inner {
        override fun toString(): String {
            return "Inner class of A"
        }
    }

}

class B {

    inner class Inner {
        override fun toString(): String {
            return "Inner class of B"
        }
    }

}

typealias AInner = A.Inner

typealias BInner = B.Inner

fun main() {

    val aInner = A().Inner()

    val bInner = B().Inner()

    println(aInner)

    println(bInner)

    // Instead, we can reference to inner classes using alternative names
    // to avoid confusion in class names
    val aInnerClass = A().AInner()

    val bInnerClass = B().BInner()

    println(aInnerClass)

    println(bInnerClass)

}