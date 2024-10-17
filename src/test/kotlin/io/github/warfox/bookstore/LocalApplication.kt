package io.github.warfox.bookstore

import org.springframework.boot.fromApplication
import org.springframework.boot.with

private const val LOCAL_PROFILE = "local"

fun main(args: Array<String>) {
    fromApplication<DemoApplication>().with(TestcontainersConfiguration::class).run(*args)
}
