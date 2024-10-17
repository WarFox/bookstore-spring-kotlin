package io.github.warfox.services

import io.github.warfox.domain.Author
import io.github.warfox.repositories.AuthorsRepository
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
