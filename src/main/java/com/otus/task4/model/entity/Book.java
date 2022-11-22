package com.otus.task4.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_genre",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private List<Genre> genres;

    @JoinColumn(name = "id_author")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
    private List<Comment> comments;

    private Boolean isRead;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setGenres(List<Genre> genre) {
        this.genres = genre;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Boolean getRead() {
        return isRead;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
