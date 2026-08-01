package com.github.robsonrjunior.gestao.tickets.controllers;

import com.github.robsonrjunior.gestao.tickets.dto.TicketListItem;
import com.github.robsonrjunior.gestao.tickets.service.TicketService;
import com.github.robsonrjunior.gestao.tickets.views.TicketLazyDataModel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.RolesAllowed;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class TicketListController implements Serializable {

    @Inject
    private TicketService ticketService;

    private TicketLazyDataModel lazyTickets;
    private List<TicketListItem> selectedTickets;
    private TicketListItem selectedTicket;

    @PostConstruct
    public void init() {
        lazyTickets = new TicketLazyDataModel(ticketService);
    }

    public TicketLazyDataModel getLazyTickets() {
        return lazyTickets;
    }

    public List<TicketListItem> getSelectedTickets() {
        return selectedTickets;
    }

    public void setSelectedTickets(List<TicketListItem> selectedTickets) {
        this.selectedTickets = selectedTickets;
    }

    public TicketListItem getSelectedTicket() {
        return selectedTicket;
    }

    public void setSelectedTicket(TicketListItem selectedTicket) {
        this.selectedTicket = selectedTicket;
    }

    public void deleteTicket() {
        if (selectedTicket != null && selectedTicket.id() != null) {
            ticketService.delete(selectedTicket.id());
            addMessage(FacesMessage.SEVERITY_INFO, "Ticket excluido", "Ticket removido com sucesso.");
        }
    }

    public void deleteSelectedTickets() {
        if (hasSelectedTickets()) {
            for (TicketListItem ticket : new ArrayList<>(selectedTickets)) {
                ticketService.delete(ticket.id());
            }
            selectedTickets = null;
            addMessage(FacesMessage.SEVERITY_INFO, "Tickets excluidos", "Tickets selecionados removidos com sucesso.");
        }
    }

    public boolean hasSelectedTickets() {
        return selectedTickets != null && !selectedTickets.isEmpty();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedTickets()) {
            int size = selectedTickets.size();
            return size > 1 ? size + " tickets selecionados" : "1 ticket selecionado";
        }
        return "Excluir";
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
