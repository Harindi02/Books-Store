package com.mycompany.booksstore.Service;

import com.mycompany.booksstore.Exceptions.AuthorNotFoundException;
import com.mycompany.booksstore.models.Author;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorService {
    private static final Map<Integer, Author> authors = new HashMap<>();
    private static int nextId = 1;

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors.values());
    }

    public Author getAuthor(int authorId) {
        Author author = authors.get(authorId);
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + authorId + " not found");
        }
        return author;
    }

    public Author addAuthor(Author author) {
        author.setAuthorId(nextId++);  // Uses the renamed setter
        authors.put(author.getAuthorId(), author);
        return author;
    }

    public Author updateAuthor(int authorId, Author author) {
        if (!authors.containsKey(authorId)) {
            throw new AuthorNotFoundException("Author with ID " + authorId + " not found");
        }
        author.setAuthorId(authorId);
        authors.put(authorId, author);
        return author;
    }

    public void deleteAuthor(int authorId) {
        if (!authors.containsKey(authorId)) {
            throw new AuthorNotFoundException("Author with ID " + authorId + " not found");
        }
        authors.remove(authorId);
    }
}