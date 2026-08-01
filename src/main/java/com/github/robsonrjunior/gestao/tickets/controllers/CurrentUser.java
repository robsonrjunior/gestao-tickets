package com.github.robsonrjunior.gestao.tickets.controllers;

import com.github.robsonrjunior.gestao.tickets.model.User;
import com.github.robsonrjunior.gestao.tickets.repository.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CurrentUser {

    @Inject
    private UserRepository userRepository;

    public boolean isLoggedIn() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (ctx == null) {
            return false;
        }
        return ctx.getExternalContext().getUserPrincipal() != null;
    }

    public boolean isAdmin() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (ctx == null) {
            return false;
        }
        return ctx.getExternalContext().isUserInRole("ADMIN");
    }

    public String getUsername() {
        if (!isLoggedIn()) {
            return null;
        }
        return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    }

    public User getUser() {
        String username = getUsername();
        if (username == null) {
            return null;
        }
        return userRepository.findByUsername(username).orElse(null);
    }
}
