package com.otus.task4.mapper;

import com.otus.task4.model.dto.CommentDto;
import com.otus.task4.model.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentDto toCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());

        return commentDto;
    }

}
