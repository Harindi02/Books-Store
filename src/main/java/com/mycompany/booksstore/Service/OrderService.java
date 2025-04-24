/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.Service;

/**
 *
 * @author ASUS OLED
 */


import com.mycompany.booksstore.Exceptions.CustomerNotFoundException;
import com.mycompany.booksstore.Exceptions.OutofStockFoundException;
import com.mycompany.booksstore.models.Book;
import com.mycompany.booksstore.models.Cart;
import com.mycompany.booksstore.models.CartItem;
import com.mycompany.booksstore.models.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private static Map<Integer, List<Order>> customerOrders = new HashMap<>();
    private static int nextOrderId = 1;
    private final CartService cartService;
    private final BookService bookService;
    private final CustomerService customerService;

    public OrderService() {
        this.cartService = new CartService();
        this.bookService = new BookService();
        this.customerService = new CustomerService();
    }

    public Order createOrder(int customerId) {
        // Verify customer exists
        customerService.getCustomer(customerId);
        
        Cart cart = cartService.getCart(customerId);
        if (cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cannot create order from empty cart");
        }
        
        // Check stock availability and calculate total
        double total = 0;
        for (CartItem item : cart.getItems()) {
            Book book = bookService.getBook(item.getBookIsbn());
            if (book.getStockQuantity() < item.getQuantity()) {
                throw new OutofStockFoundException("Not enough stock for book with ISBN " + item.getBookIsbn());
            }
            total += book.getPrice() * item.getQuantity();
        }
        
        // Decrease stock
        for (CartItem item : cart.getItems()) {
            bookService.decreaseStock(item.getBookIsbn(), item.getQuantity());
        }
        
        // Create order
        Order order = new Order(nextOrderId++, customerId, new Date(), new ArrayList<>(cart.getItems()), total);
        
        // Add to customer's orders
        customerOrders.computeIfAbsent(customerId, k -> new ArrayList<>()).add(order);
        
        // Clear the cart
        cart.getItems().clear();
        
        return order;
    }

    public List<Order> getCustomerOrders(int customerId) {
        // Verify customer exists
        customerService.getCustomer(customerId);
        
        return customerOrders.getOrDefault(customerId, new ArrayList<>());
    }

    public Order getCustomerOrder(int customerId, int orderId) {
        List<Order> orders = getCustomerOrders(customerId);
        return orders.stream()
                .filter(o -> o.getId() == orderId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }
}
