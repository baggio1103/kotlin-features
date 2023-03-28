package asynchronous.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    GlobalScope.launch {
        delay(1000L)
        println("First Coroutine")
    }
    println("Main is executing #1")

    GlobalScope.launch {
        delay(1000)
        println("Second coroutine")
    }
    println("Main is executing #2")

    GlobalScope.launch {
        delay(1000)
        println("Third coroutine")
    }
    println("Main is executing #3")
    Thread.sleep(1100)
    println("Main finished execution...")

}