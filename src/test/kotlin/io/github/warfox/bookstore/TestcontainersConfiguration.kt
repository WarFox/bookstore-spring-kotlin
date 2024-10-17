package io.github.warfox.bookstore

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {
    companion object {
        private val POSTGRES_IMAGE = DockerImageName.parse("postgres:latest")
    }

    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> =
        PostgreSQLContainer<Nothing>(POSTGRES_IMAGE).apply {
            withDatabaseName("bookstore_db")
            withUsername("bookstore_user")
            withPassword("bookstore_password")
            start()
        }
}
