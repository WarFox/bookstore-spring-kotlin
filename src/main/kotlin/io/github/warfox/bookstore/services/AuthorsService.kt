package io.github.warfox.bookstore.services

import io.github.warfox.bookstore.domain.Author
import io.github.warfox.bookstore.repositories.AuthorsRepository
import org.springframework.stereotype.Service

interface AuthorsService {
    fun getAuthors(): List<Author>
}

data class ServiceFailure(val message: String = "")

@Service
class AuthorsServiceImpl(private val authorsRepository: AuthorsRepository) : AuthorsService {
    override fun getAuthors(): List<Author> {
        return authorsRepository.getAuthors()
    }
}
