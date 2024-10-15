package io.github.warfox.domain

import java.util.UUID

data class Author(
    val id: UUID,
    val firstName: String,
    val lastName: String,
)

data class AuthorBook(
    val authorId: UUID,
    val bookId: UUID,
)

data class Book(
    val id: UUID,
    val title: String,
)
