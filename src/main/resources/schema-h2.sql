CREATE TABLE IF NOT EXISTS genre
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)                      NOT NULL
);

CREATE TABLE IF NOT EXISTS author
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255)                      NOT NULL,
    last_name  VARCHAR(255)                      NOT NULL
);

CREATE TABLE IF NOT EXISTS book
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name        VARCHAR(255)                      NOT NULL,
    description VARCHAR(255)                      NOT NULL,
    id_author   INTEGER                           NOT NULL,
    is_read     BOOLEAN,
    CONSTRAINT id_author FOREIGN KEY (id_author) REFERENCES Author (id)
);

CREATE TABLE IF NOT EXISTS book_genre
(
    book_id  integer NOT NULL,
    genre_id integer NOT NULL,
    PRIMARY KEY (book_id, genre_id),
    FOREIGN KEY (book_id) REFERENCES book (id),
    FOREIGN KEY (genre_id) REFERENCES genre (id)
);

CREATE TABLE IF NOT EXISTS comment
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    text    VARCHAR(255)                      NOT NULL,
    id_book INTEGER                           NOT NULL,
    CONSTRAINT id_book FOREIGN KEY (id_book) REFERENCES book (id)
);