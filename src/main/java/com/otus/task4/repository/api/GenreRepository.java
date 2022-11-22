package com.otus.task4.repository.api;

import com.otus.task4.model.entity.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> findAll();

}
