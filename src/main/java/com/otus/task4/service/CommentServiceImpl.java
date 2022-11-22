package com.otus.task4.service;

import com.otus.task4.mapper.CommentMapper;
import com.otus.task4.model.dto.CommentDto;
import com.otus.task4.repository.api.CommentRepository;
import com.otus.task4.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CommentDto> findAllByBookId(Long bookId) {
        return commentRepository.findAllByBookId(bookId).stream()
                .map(commentMapper::toCommentDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public CommentDto findCommentByIdInBookById(Long bookId, Long commentId) {
        return commentMapper.toCommentDto(commentRepository.findCommentByIdInBookById(bookId, commentId));
    }

    @Transactional
    @Override
    public void deleteCommentByIdInBookById(Long bookId, Long commentId) {
        commentRepository.deleteCommentByIdInBookById(bookId, commentId);
    }

    @Transactional
    @Override
    public CommentDto save(Long bookId, String comment) {
        return commentMapper.toCommentDto(commentRepository.save(bookId, comment));
    }

    @Transactional
    @Override
    public CommentDto update(Long commentId, String comment) {
        return commentMapper.toCommentDto(commentRepository.update(commentId, comment));
    }
}
