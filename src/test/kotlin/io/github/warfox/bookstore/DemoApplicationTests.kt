package io.github.warfox.bookstore

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class DemoApplicationTests {
    @Test
    fun contextLoads() {
    }
}