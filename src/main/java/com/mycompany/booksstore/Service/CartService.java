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
import com.mycompany.booksstore.Exceptions.CartNotFoundException;
import com.mycompany.booksstore.Exceptions.CustomerNotFoundException;
import com.mycompany.booksstore.Exceptions.OutofStockFoundException;
import com.mycompany.booksstore.models.Cart;
import com.mycompany.booksstore.models.CartItem;
import java.util.HashMap;
import java.util.Map;

public class CartService {
    private static Map<Integer, Cart> carts = new HashMap<>();
    private final BookService bookService;
    private final CustomerService customerService;

    public CartService() {
        this.bookService = new BookService();
        this.customerService = new CustomerService();
    }

    public Cart getCart(int customerId) {
        // Verify customer exists
        customerService.getCustomer(customerId);
        
        if (!carts.containsKey(customerId)) {
            throw new CartNotFoundException("Cart for customer ID " + customerId + " not found");
        }
        return carts.get(customerId);
    }

    public Cart createCart(int customerId) {
        // Verify customer exists
        customerService.getCustomer(customerId);
        
        if (carts.containsKey(customerId)) {
            return carts.get(customerId);
        }
        Cart cart = new Cart(customerId);
        carts.put(customerId, cart);
        return cart;
    }

    public Cart addItemToCart(int customerId, CartItem item) {
        Cart cart = getOrCreateCart(customerId);
        
        // Verify book exists and has enough stock
        bookService.getBook(item.getBookIsbn());
        
        // Check if item already exists in cart
        for (CartItem cartItem : cart.getItems()) {
            if (cartItem.getBookIsbn().equals(item.getBookIsbn())) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                return cart;
            }
        }
        
        // Add new item to cart
        cart.getItems().add(item);
        return cart;
    }

    public Cart updateCartItem(int customerId, String bookIsbn, int quantity) {
        Cart cart = getCart(customerId);
        
        for (CartItem item : cart.getItems()) {
            if (item.getBookIsbn().equals(bookIsbn)) {
                item.setQuantity(quantity);
                return cart;
            }
        }
        
        throw new BookNotFoundException("Book with ISBN " + bookIsbn + " not found in cart");
    }

    public Cart removeItemFromCart(int customerId, String bookIsbn) {
        Cart cart = getCart(customerId);
        
        cart.getItems().removeIf(item -> item.getBookIsbn().equals(bookIsbn));
        return cart;
    }

    private Cart getOrCreateCart(int customerId) {
        try {
            return getCart(customerId);
        } catch (CartNotFoundException e) {
            return createCart(customerId);
        }
    }
}
