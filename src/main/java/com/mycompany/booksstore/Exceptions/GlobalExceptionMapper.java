package com.mycompany.booksstore.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof BookNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessage(exception.getMessage()))
                    .build();
        } else if (exception instanceof AuthorNotFoundException || 
                  exception instanceof CustomerNotFoundException ||
                  exception instanceof CartNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorMessage(exception.getMessage()))
                    .build();
        } else if (exception instanceof InvalidInputException || 
                 exception instanceof IllegalArgumentException) {  // Added IllegalArgumentException here
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage(exception.getMessage()))
                    .build();
        } else if (exception instanceof OutofStockFoundException) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorMessage(exception.getMessage()))
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorMessage("Internal server error"))
                    .build();
        }
    }
}

class ErrorMessage {
    private String message;
    
    public ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    // Add setter if needed for JSON serialization
    public void setMessage(String message) {
        this.message = message;
    }
}