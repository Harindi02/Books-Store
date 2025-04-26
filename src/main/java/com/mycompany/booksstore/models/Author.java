package com.mycompany.booksstore.models;

import javax.json.bind.annotation.JsonbProperty;

public class Author {
    private int authorId;  // Field renamed to lowercase
    private String name;
    private String biography;

    // Constructors
    public Author() {}

    public Author(int authorId, String name, String biography) {
        this.authorId = authorId;
        this.name = name;
        this.biography = biography;
    }

    // Getters and Setters with JSON-B annotations
    @JsonbProperty("authorId")
    public int getAuthorId() {
        return authorId;
    }

    @JsonbProperty("authorId")
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
} 

