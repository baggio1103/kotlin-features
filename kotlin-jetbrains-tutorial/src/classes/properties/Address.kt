package classes.properties


class Address {

    val postCode: String = "123321"
    var latitude: String = ""
        get() {
            println("Getting field latitude")
            return field
        }
        set(value) {
            println("Setting field latitude value - $value")
            field = value
        }

    lateinit var name: String
}

fun main() {
    val address = Address()
    println(address.postCode)
    address.name = "Walk Street"
    address.latitude = "49.589"
    println(address.latitude)
}
