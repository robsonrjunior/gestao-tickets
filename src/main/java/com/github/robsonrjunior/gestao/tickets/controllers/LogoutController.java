package com.github.robsonrjunior.gestao.tickets.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LogoutController {

    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        try {
            request.logout();
            request.getSession().invalidate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "/login?faces-redirect=true";
    }
}
