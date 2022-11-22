package com.otus.task4.repository.api;

import com.otus.task4.model.entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();

    Book findById(Long id);

    void deleteById(Long id);

    Book save(String name, String description, Long idAuthor, List<String> genres);

    Book update(Long id, String name, String description, Long idAuthor, List<String> genres);

    void setIsRead(Long id);
}
