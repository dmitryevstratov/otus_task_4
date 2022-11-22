package com.otus.task4.model.dto;

public class GenreDto {

    public GenreDto() {
    }

    public GenreDto(String name) {
        this.name = name;
    }

    private Long id;

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenreDto{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
