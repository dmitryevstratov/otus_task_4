INSERT INTO GENRE (name)
VALUES ('Драма');
INSERT INTO GENRE (name)
VALUES ('Боевик');
INSERT INTO GENRE (name)
VALUES ('Комедия');
INSERT INTO GENRE (name)
VALUES ('Фантастика');

INSERT INTO AUTHOR (first_name, last_name)
VALUES ('Александр', 'Пушкин');
INSERT INTO AUTHOR (first_name, last_name)
VALUES ('Михаил', 'Булгаков');

INSERT INTO BOOK ( name, description, id_author)
VALUES ('Звездные войны', 'Война и политика в космосе', 1);
INSERT INTO BOOK (name, description, id_author)
VALUES ('Мастер и Маргарита', 'Про большого кота', 2);

INSERT INTO BOOK_GENRE VALUES (1, 1);
INSERT INTO BOOK_GENRE VALUES (1, 2);
INSERT INTO BOOK_GENRE VALUES (2, 3);
INSERT INTO BOOK_GENRE VALUES (2, 4);