/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.resources;

/**
 *
 * @author ASUS OLED
 */



import com.mycompany.booksstore.Service.CartService;
import com.mycompany.booksstore.models.Cart;
import com.mycompany.booksstore.models.CartItem;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
    private CartService cartService = new CartService();

    @GET
    public Cart getCart(@PathParam("customerId") int customerId) {
        return cartService.getCart(customerId);
    }

    @POST
    @Path("/items")
    public Cart addItemToCart(@PathParam("customerId") int customerId, CartItem item) {
        return cartService.addItemToCart(customerId, item);
    }

    @PUT
    @Path("/items/{bookIsbn}")
    public Cart updateCartItem(@PathParam("customerId") int customerId, 
                             @PathParam("bookIsbn") String bookIsbn, 
                             int quantity) {
        return cartService.updateCartItem(customerId, bookIsbn, quantity);
    }

    @DELETE
    @Path("/items/{bookIsbn}")
    public Response removeItemFromCart(@PathParam("customerId") int customerId, 
                                     @PathParam("bookIsbn") String bookIsbn) {
        cartService.removeItemFromCart(customerId, bookIsbn);
        return Response.noContent().build();
    }
}