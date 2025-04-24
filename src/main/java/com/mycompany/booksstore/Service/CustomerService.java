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
import com.mycompany.booksstore.models.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static int nextId = 1;

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomer(int id) {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        return customer;
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(nextId++);
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateCustomer(int id, Customer customer) {
        if (!customers.containsKey(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        customer.setId(id);
        customers.put(id, customer);
        return customer;
    }

    public void deleteCustomer(int id) {
        if (!customers.containsKey(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        customers.remove(id);
    }
}