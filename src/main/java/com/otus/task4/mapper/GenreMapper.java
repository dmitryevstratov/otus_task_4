package com.otus.task4.mapper;

import com.otus.task4.model.entity.Genre;
import com.otus.task4.model.dto.GenreDto;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public GenreDto toGenreDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        return genreDto;
    }

}
