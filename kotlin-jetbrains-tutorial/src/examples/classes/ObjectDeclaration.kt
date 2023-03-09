package examples.classes

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int) {
    val dayRates = object {
        val standard = 30 * standardDays
        val festivity = 50 * festivityDays
        val special = 30 * specialDays
    }
    val total = dayRates.standard + dayRates.festivity + dayRates.special
    println("Total rent $total")
}

object DoAuth {
    fun takeParams(username: String, password: String) {
        print("Input authentication params: $username - $password\n")
    }
}

class BigBen {
    //Object declaration inside a class leads to another useful case
    //Companion object are like static method in Java
    companion object Bong {
        fun getBongs(times: Int) {
            for (i in 0..times) {
                print("Bong  ")
            }
        }
    }
}

fun main() {
    // object in kotlin is lazily inited, when it is accessed
    // object declaration inside a method, like Java anonymous classes
    rentPrice(10, 2, 2)

    DoAuth.takeParams("wayne", "qwerty")

    BigBen.getBongs(10)
}