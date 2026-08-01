package com.github.robsonrjunior.gestao.tickets.apis;

import com.github.robsonrjunior.gestao.tickets.model.User;
import com.github.robsonrjunior.gestao.tickets.service.UserService;
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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("users")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class UserResource {

    @Inject
    private UserService service;

    @GET
    public List<User> list() {
        return service.list();
    }

    @GET
    @Path("{id}")
    public User get(@PathParam("id") Long id) {
        return service.get(id);
    }

    @POST
    public Response create(@Valid User user) {
        return Response.status(Response.Status.CREATED).entity(service.create(user)).build();
    }

    @PUT
    @Path("{id}")
    public User update(@PathParam("id") Long id, @Valid User user) {
        return service.update(id, user);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
