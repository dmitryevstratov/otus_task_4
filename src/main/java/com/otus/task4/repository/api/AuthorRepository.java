package com.otus.task4.repository.api;

import com.otus.task4.model.entity.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> findAll();

    Author findById(Long id);

}
