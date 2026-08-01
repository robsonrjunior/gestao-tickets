package com.github.robsonrjunior.gestao.tickets.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.List;
import java.util.Map;

@Provider
public class ConstraintViolationExceptionMapper
    implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        List<Map<String, String>> violations = exception
            .getConstraintViolations()
            .stream()
            .map(this::describe)
            .toList();
        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(Map.of("status", 400, "violations", violations))
            .build();
    }

    private Map<String, String> describe(ConstraintViolation<?> violation) {
        return Map.of(
            "field",
            violation.getPropertyPath().toString(),
            "message",
            violation.getMessage()
        );
    }
}
