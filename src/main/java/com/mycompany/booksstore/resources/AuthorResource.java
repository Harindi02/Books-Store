 
package com.mycompany.booksstore.resources;

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
    private final AuthorService authorService = new AuthorService();
    private final BookService bookService = new BookService();

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
    @Path("/{authorId}")
    public Author getAuthor(@PathParam("authorId") int authorId) {
        return authorService.getAuthor(authorId);
    }

    @PUT
    @Path("/{authorId}")
    public Author updateAuthor(@PathParam("authorId") int authorId, Author author) {
        return authorService.updateAuthor(authorId, author);
    }

    @DELETE
    @Path("/{authorId}")
    public Response deleteAuthor(@PathParam("authorId") int authorId) {
        authorService.deleteAuthor(authorId);
        return Response.noContent().build();
    }

    @GET
    @Path("/{authorId}/books")
    public List<Book> getBooksByAuthor(@PathParam("authorId") int authorId) {
        List<Book> allBooks = bookService.getAllBooks();
        allBooks.removeIf(book -> book.getAuthorID() != authorId);
        return allBooks;
    }
}
