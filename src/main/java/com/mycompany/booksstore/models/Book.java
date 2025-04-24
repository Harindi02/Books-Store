/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.models;

/**
 *
 * @author ASUS OLED
 */
import java.util.Objects;

public class Book {
    
    private String isbn;
    private String title;
    private int authorID;
    private int issuedYear;
    private double price;
    private int stockQuantity;

    //constructor,getters,setters
    public Book(){}
    
    public Book(String isbn , String title, int authorID, int issuedYear, double price,int stockQuantity){
        this.isbn = isbn;
        this.title = title;
        this.authorID = authorID;
        this.issuedYear = issuedYear;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    // Getters and setters for all fields
    public String getIsbn() {
        return isbn; }
    public void setIsbn(String isbn) { 
        this.isbn = isbn; }
    public String getTitle() { 
        return title; }
    public void setTitle(String title) {
        this.title = title; }
    public int getAuthorID() { 
        return authorID; }
    public void setAuthorId(int authorID) {
        this.authorID = authorID; }
    public int getissuedYear() {
        return issuedYear; }
    public void setPublicationYear(int issuedYear) {
        this.issuedYear = issuedYear; }
    public double getPrice() {
        return price; }
    public void setPrice(double price) { 
        this.price = price; }
    public int getStockQuantity() { 
        return stockQuantity; }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity; }


     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }



}
