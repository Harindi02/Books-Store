/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int customerId;
    private List<CartItem> items = new ArrayList<>();

    public Cart(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() { return customerId; }
    public List<CartItem> getItems() { return items; }
}
