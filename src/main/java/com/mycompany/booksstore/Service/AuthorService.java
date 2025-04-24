/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.Service;

/**
 *
 * @author ASUS OLED
 */


import com.mycompany.booksstore.Exceptions.AuthorNotFoundException;
import com.mycompany.booksstore.models.Author;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorService {
    private static Map<Integer, Author> authors = new HashMap<>();
    private static int nextId = 1;

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors.values());
    }

    public Author getAuthor(int id) {
        Author author = authors.get(id);
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }
        return author;
    }

    public Author addAuthor(Author author) {
        author.setId(nextId++);
        authors.put(author.getId(), author);
        return author;
    }

    public Author updateAuthor(int id, Author author) {
        if (!authors.containsKey(id)) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }
        author.setId(id);
        authors.put(id, author);
        return author;
    }

    public void deleteAuthor(int id) {
        if (!authors.containsKey(id)) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }
        authors.remove(id);
    }
}
