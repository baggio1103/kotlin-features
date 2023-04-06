package classes.enums

enum class ProtocolState {

    WAITING {
        override fun signal(): ProtocolState = TALKING

    },

    TALKING {
        override fun signal(): ProtocolState = WAITING
    };

    abstract fun signal(): ProtocolState

}

fun main() {
    ProtocolState.values().forEach {
        println("It's state: $it, signal - ${it.signal()}")
    }
    ProtocolState.values().forEach {
        println(it.name)
    }
    ProtocolState.values().forEach {
        println("$it ordinal number: ${it.ordinal}")
    }
}