/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booksstore.resources;

/**
 *
 * @author ASUS OLED
 */


import com.mycompany.booksstore.Service.AuthorService;
import com.mycompany.booksstore.Service.BookService;
import com.mycompany.booksstore.models.Author;
import com.mycompany.booksstore.models.Book;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    private AuthorService authorService = new AuthorService();
    private BookService bookService = new BookService();

    @GET
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @POST
    public Response addAuthor(Author author) {
        Author newAuthor = authorService.addAuthor(author);
        return Response.status(Response.Status.CREATED).entity(newAuthor).build();
    }

    @GET
    @Path("/{id}")
    public Author getAuthor(@PathParam("id") int id) {
        return authorService.getAuthor(id);
    }

    @PUT
    @Path("/{id}")
    public Author updateAuthor(@PathParam("id") int id, Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") int id) {
        authorService.deleteAuthor(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}/books")
    public List<Book> getBooksByAuthor(@PathParam("id") int authorId) {
        List<Book> allBooks = bookService.getAllBooks();
        allBooks.removeIf(book -> book.getAuthorID() != authorId);
        return allBooks;
    }
}