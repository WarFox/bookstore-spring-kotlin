DROP TABLE IF EXISTS author_books, authors, books;

CREATE TABLE authors
(
    id
        UUID        NOT NULL PRIMARY KEY,
    first_name
        VARCHAR(50),
    last_name
        VARCHAR(50) NOT NULL
);

CREATE TABLE books
(
    id
        UUID         NOT NULL PRIMARY KEY,
    title
        VARCHAR(100) NOT NULL
);

CREATE TABLE author_books
(
    author_id UUID NOT NULL,
    book_id   UUID NOT NULL,
    PRIMARY KEY (author_id, book_id),
    CONSTRAINT fk_ab_author
        FOREIGN KEY (author_id)
            REFERENCES authors (id)
            ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_ab_book
        FOREIGN KEY (book_id) REFERENCES books (id)
);

INSERT
INTO authors
VALUES (gen_random_uuid(), 'Kathy', 'Sierra'),
       (gen_random_uuid(), 'Bert', 'Bates'),
       (gen_random_uuid(), 'Bryan', 'Basham');

INSERT
INTO books
VALUES (gen_random_uuid(), 'Head First Java'),
       (gen_random_uuid(), 'Head First Servlets and JSP'),
       (gen_random_uuid(), 'OCA/OCP Java SE 7 Programmer');

-- INSERT INTO author_books VALUES (1, 1), (1, 3), (2, 1);
