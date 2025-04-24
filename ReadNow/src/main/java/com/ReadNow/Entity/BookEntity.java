package com.ReadNow.Entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "Book")
public class BookEntity {

    public BookEntity(Long id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public BookEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;

    public BookEntity(Long id) {
        this.id = id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookEntity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public BookEntity setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }
}



