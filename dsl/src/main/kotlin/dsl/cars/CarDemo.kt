package dsl.cars

fun main() {
    val car = car {
        make { "Toyota" }
        model { "Camry" }
        year { 2024 }
        color { "Silver" }
        features {
            add { "Navigation System" }
            add { "Cruise Control" }
            add { "Sunroof" }
        }
    }
    println(
        car
    )
}