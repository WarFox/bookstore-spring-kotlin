package io.github.warfox.repositories

import io.github.warfox.domain.Author
import io.github.warfox.jooq.Tables.AUTHORS
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
interface AuthorsRepository {
    fun getAuthors(): List<Author>
}

@Repository
class JooqAuthorsRepository(private val dslContext: DSLContext) : AuthorsRepository {
    override fun getAuthors(): List<Author> {
        return dslContext.select(
            AUTHORS.ID,
            AUTHORS.FIRST_NAME,
            AUTHORS.LAST_NAME
        ).from(AUTHORS).fetch().map { record ->
            Author(
                id = record[AUTHORS.ID],
                firstName = record[AUTHORS.FIRST_NAME],
                lastName = record[AUTHORS.LAST_NAME]
            )
        }
    }
}
