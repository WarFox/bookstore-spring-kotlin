package io.github.warfox.bookstore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runCatching { runApplication<DemoApplication>(args = args) }.onFailure {
        System.err.println("main method exception: ${it.stackTraceToString()}")
    }
}
