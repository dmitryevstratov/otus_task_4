package com.otus.task4.service.api;

import com.otus.task4.model.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto save(String name, String description, Long idAuthor, List<String> genres);

    BookDto update(Long id, String name, String description, Long idAuthor, List<String> genres);

    void deleteById(Long id);

    BookDto getById(Long id);

    List<BookDto> findAll();

    void setIsRead(Long id);
}
