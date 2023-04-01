package classes.extension

open class Base

class Derived: Base()

open class BaseCaller {

    open fun Base.printFunctionInfo() {
        println("Base extension in BaseCaller")
    }

    open fun Derived.printFunctionInfo() {
        println("Derived extension in BaseCaller")
    }

    fun call(b: Base) {
        b.printFunctionInfo()
    }

}

class DerivedCaller: BaseCaller() {

    override fun Base.printFunctionInfo() {
        println("Base extension in DerivedCaller")
    }

    override fun Derived.printFunctionInfo() {
        println("Derived extension in DerivedCaller")
    }

}

fun main() {
    BaseCaller().call(Base())
    DerivedCaller().call(Derived())
    DerivedCaller().call(Derived())
}