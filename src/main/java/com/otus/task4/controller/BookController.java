package com.otus.task4.controller;

import com.otus.task4.model.dto.BookDto;
import com.otus.task4.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<BookDto>> findAllBook() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find_by_id/{id}")
    public BookDto getBookById(@PathVariable("id") Long id) {
        return bookService.getById(id);
    }

    @PostMapping("/save")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto.getName(), bookDto.getDescription(), bookDto.getIdAuthor(), bookDto.getGenres());
    }

    @PutMapping("/update/{id}")
    public BookDto updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
        return bookService.update(id, bookDto.getName(), bookDto.getDescription(), bookDto.getIdAuthor(), bookDto.getGenres());
    }

    @PutMapping("/is_read/{id}")
    public void bookIsRead(@PathVariable("id") Long id) {
        bookService.setIsRead(id);
    }
}
