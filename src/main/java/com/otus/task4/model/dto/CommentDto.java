package com.otus.task4.model.dto;

public class CommentDto {

    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
