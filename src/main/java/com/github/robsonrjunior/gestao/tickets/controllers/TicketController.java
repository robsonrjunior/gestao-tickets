package com.github.robsonrjunior.gestao.tickets.controllers;

import com.github.robsonrjunior.gestao.tickets.exception.ResourceNotFoundException;
import com.github.robsonrjunior.gestao.tickets.model.Ticket;
import com.github.robsonrjunior.gestao.tickets.model.User;
import com.github.robsonrjunior.gestao.tickets.repository.UserRepository;
import com.github.robsonrjunior.gestao.tickets.service.TicketService;
import jakarta.faces.FacesException;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class TicketController implements Serializable {

    private static final String CREATE = "create";
    private static final String EDIT = "edit";
    private static final String VIEW = "view";

    @Inject
    private TicketService ticketService;

    @Inject
    private UserRepository userRepository;

    @Inject
    private CurrentUser currentUser;

    private Long id;
    private String mode;
    private Ticket ticket = new Ticket();
    private List<User> userList;

    public void loadForm() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.isPostback()) {
            return;
        }
        readViewParameters(context);
        userList = userRepository.findAll();
        if (CREATE.equals(mode) || id == null) {
            mode = CREATE;
            ticket = new Ticket();
            return;
        }
        if (mode == null) {
            mode = VIEW;
        }
        try {
            ticket = ticketService.get(id);
            if (!currentUser.isAdmin() && EDIT.equals(mode)) {
                mode = VIEW;
            }
        } catch (ResourceNotFoundException e) {
            redirectToListWithError();
        }
    }

    private void readViewParameters(FacesContext context) {
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        String idParam = params.get("id");
        if (idParam != null && !idParam.isBlank()) {
            try {
                id = Long.valueOf(idParam.trim());
            } catch (NumberFormatException e) {
                id = null;
            }
        }
        String modeParam = params.get("mode");
        if (modeParam != null && !modeParam.isBlank()) {
            mode = modeParam.trim();
        }
    }

    public String save() {
        boolean creating = ticket.getId() == null;
        if (creating) {
            ticketService.create(ticket);
        } else {
            ticketService.update(ticket.getId(), ticket);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(
            null,
            new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                creating ? "Ticket criado" : "Ticket atualizado",
                "Ticket salvo com sucesso."
            )
        );
        return "ticket-list?faces-redirect=true";
    }

    private void redirectToListWithError() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ticket não encontrado", "O ticket solicitado não existe.")
        );
        try {
            context
                .getExternalContext()
                .redirect(context.getExternalContext().getRequestContextPath() + "/ticket-list.xhtml");
        } catch (IOException e) {
            throw new FacesException(e);
        }
    }

    public boolean isCreateMode() {
        return CREATE.equals(mode);
    }

    public boolean isEditMode() {
        return EDIT.equals(mode);
    }

    public boolean isViewMode() {
        return VIEW.equals(mode);
    }

    public boolean canSave() {
        return currentUser.isAdmin();
    }

    public String getPageTitle() {
        if (isCreateMode()) {
            return "Novo Ticket";
        }
        if (isEditMode()) {
            return "Editar Ticket";
        }
        return "Detalhes do Ticket";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getAssigneeDisplayName() {
        if (ticket.getAssignee() == null) {
            return "Unassigned";
        }
        String name = ticket.getAssignee().getDisplayName();
        return name != null && !name.isBlank() ? name : ticket.getAssignee().getUsername();
    }
}
