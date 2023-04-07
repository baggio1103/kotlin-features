package classes.`object`

interface RemoteRegister<T> {

    fun register(value: T)

}

object SmartUserRegister: RemoteRegister<String> {

    private val list = mutableListOf<String>()

    override fun register(value: String) {
        list.add(value)
    }

}

fun main() {
    val smartRegister = SmartUserRegister
    smartRegister.register("wayne")
}