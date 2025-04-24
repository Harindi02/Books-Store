/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.resources;

/**
 *
 * @author ASUS OLED
 */


import com.mycompany.booksstore.Service.OrderService;
import com.mycompany.booksstore.models.Order;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    private OrderService orderService = new OrderService();

    @POST
    public Response createOrder(@PathParam("customerId") int customerId) {
        Order order = orderService.createOrder(customerId);
        return Response.status(Response.Status.CREATED).entity(order).build();
    }

    @GET
    public List<Order> getCustomerOrders(@PathParam("customerId") int customerId) {
        return orderService.getCustomerOrders(customerId);
    }

    @GET
    @Path("/{orderId}")
    public Order getCustomerOrder(@PathParam("customerId") int customerId, 
                                @PathParam("orderId") int orderId) {
        return orderService.getCustomerOrder(customerId, orderId);
    }
}