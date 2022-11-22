package com.otus.task4.controller;

import com.otus.task4.model.dto.CommentDto;
import com.otus.task4.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class CommentShell {

    private final CommentService commentService;

    @Autowired
    public CommentShell(CommentService commentService) {
        this.commentService = commentService;
    }

    @ShellMethod(key = "comment-R", value = "Comment find all")
    public List<CommentDto> findAllComments(Long bookId) {
        return commentService.findAllByBookId(bookId);
    }

    @ShellMethod(key = "delete-comment", value = "Delete comment by id")
    public void deleteCommentById(Long bookId, Long commentId) {
        commentService.deleteCommentByIdInBookById(bookId, commentId);
    }

    @ShellMethod(key = "comment-ID", value = "Get comment by id")
    public CommentDto getCommentsById(Long bookId, Long commentId) {
        return commentService.findCommentByIdInBookById(bookId, commentId);
    }

    @ShellMethod(key = "save-comment", value = "Save comment")
    public CommentDto saveComments(Long bookId, String text) {
        return commentService.save(bookId, text);
    }

    @ShellMethod(key = "update-comment", value = "Update comment")
    public CommentDto updateComments(Long commentId, String text) {
        return commentService.update(commentId, text);
    }
}
