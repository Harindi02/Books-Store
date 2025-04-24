/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.resources;

/**
 *
 * @author ASUS OLED
 */
 

import com.mycompany.booksstore.Service.BookService;
import com.mycompany.booksstore.models.Book;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    private BookService bookService = new BookService();

    @GET
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @POST
    public Response addBook(Book book) {
        Book newBook = bookService.addBook(book);
        return Response.status(Response.Status.CREATED).entity(newBook).build();
    }

    @GET
    @Path("/{isbn}")
    public Book getBook(@PathParam("isbn") String isbn) {
        return bookService.getBook(isbn);
    }

    @PUT
    @Path("/{isbn}")
    public Book updateBook(@PathParam("isbn") String isbn, Book book) {
        return bookService.updateBook(isbn, book);
    }

    @DELETE
    @Path("/{isbn}")
    public Response deleteBook(@PathParam("isbn") String isbn) {
        bookService.deleteBook(isbn);
        return Response.noContent().build();
    }
}