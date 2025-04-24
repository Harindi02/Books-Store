/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.models;

public class CartItem {
    private String bookIsbn;
    private int quantity;

    public CartItem(String bookIsbn, int quantity) {
        this.bookIsbn = bookIsbn;
        this.quantity = quantity;
    }

    public String getBookIsbn() { return bookIsbn; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}