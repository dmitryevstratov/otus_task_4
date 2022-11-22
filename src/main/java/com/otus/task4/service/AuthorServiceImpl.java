package com.otus.task4.service;

import com.otus.task4.mapper.AuthorMapper;
import com.otus.task4.model.dto.AuthorDto;
import com.otus.task4.repository.api.AuthorRepository;
import com.otus.task4.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<AuthorDto> getAllAuthor() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toAuthorDto)
                .collect(Collectors.toList());
    }

}
