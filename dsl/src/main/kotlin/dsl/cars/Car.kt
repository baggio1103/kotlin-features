package dsl.cars

data class Car(
    var make: String = "",
    var model: String = "",
    var year: Short = 0,
    var color: String = "",
    var features: List<String> = mutableListOf()
)

class CarBuilder {

    private val car = Car()

    fun make(make: () -> String) {
        car.make = make()
    }

    fun model(model: () -> String) {
        car.model = model()
    }

    fun year(year: () -> Short) {
        car.year = year()
    }

    fun color(color: () -> String) {
        car.color = color()
    }

    fun features(block: FeatureBuilder.() -> Unit) {
        val features = FeatureBuilder()
        features.block()
        car.features = features.features
    }

    fun build(): Car = car

}

class FeatureBuilder {

    val features = mutableListOf<String>()

    fun add(block: () -> String) {
        features.add(block())
    }

}

fun car(block: CarBuilder.() -> Unit): Car {
    val carBuilder = CarBuilder()
    carBuilder.block()
    return carBuilder.build()
}