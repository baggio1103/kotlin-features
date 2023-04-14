package rockthejvm.cancellation

import reflectoring.logger

class Desk : AutoCloseable {

    init {
        logger.info("Starting to work on the desk")
    }

    override fun close() {
        logger.info("Cleaning the desk")
    }

}