package classes.interfaces

interface CircleInterface {

    val radius: Int
        get() = 10000

}

class CircleImpl : CircleInterface {

    override var radius: Int = 0
        get() {
            return field
        }
        set(value) {
            field = value
        }

}