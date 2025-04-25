package com.mycompany.booksstore.models;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class CartItem {
    private String bookIsbn;
    private int quantity;

    // Default constructor (required for JSON deserialization)
    public CartItem() {}

    // Annotation-based constructor for JSON binding
    @JsonbCreator
    public CartItem(
        @JsonbProperty("bookIsbn") String bookIsbn,
        @JsonbProperty("quantity") int quantity
    ) {
        this.bookIsbn = bookIsbn;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getBookIsbn() { return bookIsbn; }
    public int getQuantity() { return quantity; }
    public void setBookIsbn(String bookIsbn) { this.bookIsbn = bookIsbn; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}