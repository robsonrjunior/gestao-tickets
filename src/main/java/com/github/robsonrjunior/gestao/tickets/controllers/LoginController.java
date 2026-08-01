package com.github.robsonrjunior.gestao.tickets.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Named
@RequestScoped
public class LoginController {

    private String username;
    private String password;

    @Inject
    private SecurityContext securityContext;

    public void login() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            ctx.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Username e senha sao obrigatorios."));
            return;
        }

        ExternalContext externalContext = ctx.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        securityContext.authenticate(
            request,
            response,
            AuthenticationParameters.withParams()
                .credential(new UsernamePasswordCredential(username, password))
        );

        if (request.getUserPrincipal() != null) {
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            ctx.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuario ou senha invalidos."));
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
