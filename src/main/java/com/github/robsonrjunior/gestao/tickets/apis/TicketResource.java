package com.github.robsonrjunior.gestao.tickets.apis;

import com.github.robsonrjunior.gestao.tickets.model.Ticket;
import com.github.robsonrjunior.gestao.tickets.service.TicketService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("tickets")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketResource {

    @Inject
    private TicketService service;

    @GET
    public List<Ticket> list(@QueryParam("status") String status) {
        List<Ticket> tickets = service.list();
        if (status != null && !status.isBlank()) {
            return tickets.stream()
                .filter(t -> t.getStatus().name().equalsIgnoreCase(status.trim()))
                .collect(Collectors.toList());
        }
        return tickets;
    }

    @GET
    @Path("{id}")
    public Ticket get(@PathParam("id") Long id) {
        return service.get(id);
    }

    @POST
    @RolesAllowed("ADMIN")
    public Response create(@Valid Ticket ticket) {
        return Response.status(Response.Status.CREATED).entity(service.create(ticket)).build();
    }

    @PUT
    @Path("{id}")
    @RolesAllowed("ADMIN")
    public Ticket update(@PathParam("id") Long id, @Valid Ticket ticket) {
        return service.update(id, ticket);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed("ADMIN")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
