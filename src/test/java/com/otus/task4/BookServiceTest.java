package com.otus.task4;

import com.otus.task4.model.dto.BookDto;
import com.otus.task4.service.api.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.yml")
@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = {"/schema-h2.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

    @Test
    public void findAll() {
        List<BookDto> all = bookService.findAll();

        assertEquals(2, all.size());
    }

    @Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = {"/schema-h2.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void getById() {
        BookDto bookDto = bookService.getById(1L);

        assertEquals(1, bookDto.getId());
        assertEquals("Звездные войны", bookDto.getName());
        assertEquals("Война и политика в космосе", bookDto.getDescription());
        assertEquals(1, bookDto.getIdAuthor());
    }

    @Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = {"/schema-h2.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void deleteById() {
        bookService.deleteById(1L);
        List<BookDto> all = bookService.findAll();

        assertEquals(1, all.size());
    }

    @Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = {"/schema-h2.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void save() {
        BookDto bookDto = bookService.save("Кекс", "Книга о собакене", 1L, List.of("Драма", "Боевик"));

        assertEquals(3, bookDto.getId());
        assertEquals("Кекс", bookDto.getName());
        assertEquals("Книга о собакене", bookDto.getDescription());
        assertEquals(1, bookDto.getIdAuthor());
    }

    @Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = {"/schema-h2.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void update() {
        BookDto bookDto = bookService.update(1L, "Кекс", "Книга о собакене", 1L, List.of("Драма", "Боевик"));

        assertEquals(1L, bookDto.getId());
        assertEquals("Кекс", bookDto.getName());
        assertEquals("Книга о собакене", bookDto.getDescription());
        assertEquals(1, bookDto.getIdAuthor());
    }

    @Sql(value = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = {"/schema-h2.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    public void setIsRead() {
        bookService.setIsRead(1L);

        assertTrue(bookService.findAll().stream()
                .filter(bookDto -> bookDto.getId().equals(1L))
                .findFirst()
                .map(BookDto::getRead).get());
    }

}
