package io.github.warfox.bookstore.controllers

import io.github.warfox.bookstore.domain.Author
import io.github.warfox.bookstore.services.AuthorsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorsController(val authorService: AuthorsService) {
    @GetMapping("/authors")
    fun getAuthors(): List<Author> {
        return authorService.getAuthors()
    }
}
