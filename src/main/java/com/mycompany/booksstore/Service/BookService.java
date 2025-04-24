/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.Service;

/**
 *
 * @author ASUS OLED
 */

import com.mycompany.booksstore.Exceptions.BookNotFoundException;
import com.mycompany.booksstore.Exceptions.OutofStockFoundException;
import com.mycompany.booksstore.models.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    private static Map<String, Book> books = new HashMap<>();
    private static int nextId = 1;

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
        }
        return book;
    }

    public Book addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        books.put(book.getIsbn(), book);
        return book;
    }

    public Book updateBook(String isbn, Book book) {
        if (!books.containsKey(isbn)) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
        }
        books.put(isbn, book);
        return book;
    }

    public void deleteBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
        }
        books.remove(isbn);
    }

    public void decreaseStock(String isbn, int quantity) {
        Book book = getBook(isbn);
        if (book.getStockQuantity() < quantity) {
            throw new OutofStockFoundException("Not enough stock for book with ISBN " + isbn);
        }
        book.setStockQuantity(book.getStockQuantity() - quantity);
    }
}