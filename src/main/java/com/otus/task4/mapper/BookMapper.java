package com.otus.task4.mapper;

import com.otus.task4.model.dto.BookDto;
import com.otus.task4.model.entity.Book;
import com.otus.task4.model.entity.Genre;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setDescription(book.getDescription());
        bookDto.setIdAuthor(book.getAuthor().getId());
        bookDto.setRead(book.getRead());
        bookDto.setGenres(book.getGenres().stream().map(Genre::getName).collect(Collectors.toList()));

        return bookDto;
    }

    public Book toBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        return book;
    }

}
