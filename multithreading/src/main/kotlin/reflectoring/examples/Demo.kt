package reflectoring.examples

import kotlinx.coroutines.*
import java.util.*
import reflectoring.logger as log

fun main() = runBlocking {
    log.info("Program starts execution")
    val productId = findProductId()
    launch(Dispatchers.Unconfined) {
        log.info("Price fetching started")
        val price = fetchPrice(productId)
        log.info("Price received: $price")
    }
    updateProduct(productId)
    log.info("Program finishes execution")
}

fun findProductId(): UUID {
    log.info("Finding id of product...")
    return UUID.randomUUID()
}

suspend fun fetchPrice(productId: UUID): Double {
    log.info("Fetching price of productId: $productId")
    delay(2000)
    log.info("Price fetched")
    return 300.99
}

fun updateProduct(id: UUID): String {
    log.info("Successfully updated product with id: $id")
    return "Product updated"
}