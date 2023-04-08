package classes.`typealias`

// TypeAliases introduces alternative names for existing types.
// It helps to avoid collision in ClassNames
// if there is while using classes from different libraries
// They do not introduce new types, they just provide an alternative name that is shorter
typealias CarList = MutableList<Car>

data class Car(val name: String, val topSpeed: Int)

typealias Tesla = Car

typealias FerrariPredicate<T> = (T) -> Boolean

fun main() {

    val carList: CarList = cars()

    printCars(carList)

    val tesla = Tesla("Tesla X", 1000)

    println(tesla)

    val isCarFerrari: FerrariPredicate<Car> = { car -> car.name == "Ferrari" }
    println(isCarFerrari(tesla))
    carList.filter {
        isCarFerrari(it)
    }.forEach { println(it) }
}

fun printCars(carList: MutableList<Car>) {
    carList.forEach { println(it) }
}

fun cars(): CarList {
    return mutableListOf(
        Car("Ferrari", 300),
        Car("Tesla", 250)
    )
}