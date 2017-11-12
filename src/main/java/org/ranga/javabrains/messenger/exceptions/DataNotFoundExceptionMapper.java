package org.ranga.javabrains.messenger.exceptions;

import org.ranga.javabrains.messenger.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    private static final String DOCUMENTATION = "https://www.vishnu.com";

    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage =
                new ErrorMessage(e.getMessage(), Response.Status.NOT_FOUND.getStatusCode(), DOCUMENTATION);
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
