/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.resources;

/**
 *
 * @author ASUS OLED
 */

import com.mycompany.booksstore.Service.CustomerService;
import com.mycompany.booksstore.models.Customer;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private CustomerService customerService = new CustomerService();

    @GET
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @POST
    public Response addCustomer(Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return Response.status(Response.Status.CREATED).entity(newCustomer).build();
    }

    @GET
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") int id) {
        return customerService.getCustomer(id);
    }

    @PUT
    @Path("/{id}")
    public Customer updateCustomer(@PathParam("id") int id, Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        customerService.deleteCustomer(id);
        return Response.noContent().build();
    }
}