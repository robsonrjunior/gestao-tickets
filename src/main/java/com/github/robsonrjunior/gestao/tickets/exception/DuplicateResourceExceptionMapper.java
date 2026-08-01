package com.github.robsonrjunior.gestao.tickets.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

@Provider
public class DuplicateResourceExceptionMapper
    implements ExceptionMapper<DuplicateResourceException> {

    @Override
    public Response toResponse(DuplicateResourceException exception) {
        return Response
            .status(Response.Status.CONFLICT)
            .entity(Map.of("status", 409, "message", exception.getMessage()))
            .build();
    }
}
