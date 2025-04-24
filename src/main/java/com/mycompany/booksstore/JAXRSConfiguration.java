package com.mycompany.booksstore;


import com.mycompany.booksstore.Exceptions.GlobalExceptionMapper;
import com.mycompany.booksstore.resources.AuthorResource;
import com.mycompany.booksstore.resources.BookResource;
import com.mycompany.booksstore.resources.CartResource;
import com.mycompany.booksstore.resources.CustomerResource;
import com.mycompany.booksstore.resources.OrderResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
 

@ApplicationPath("/api")
public class JAXRSConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(BookResource.class);
        resources.add(AuthorResource.class);
        resources.add(CustomerResource.class);
        resources.add(CartResource.class);
        resources.add(OrderResource.class);
        resources.add(GlobalExceptionMapper.class);
        return resources;
    }
}