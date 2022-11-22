package com.otus.task4.service;

import com.otus.task4.mapper.GenreMapper;
import com.otus.task4.model.dto.GenreDto;
import com.otus.task4.repository.api.GenreRepository;
import com.otus.task4.service.api.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GenreDto> getAllGenre() {
        return genreRepository.findAll().stream()
                .map(genreMapper::toGenreDto)
                .collect(Collectors.toList());
    }

}
