package com.github.robsonrjunior.gestao.tickets.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

@Provider
public class ResourceNotFoundExceptionMapper
    implements ExceptionMapper<ResourceNotFoundException> {

    @Override
    public Response toResponse(ResourceNotFoundException exception) {
        return Response
            .status(Response.Status.NOT_FOUND)
            .entity(Map.of("status", 404, "message", exception.getMessage()))
            .build();
    }
}
