package com.github.robsonrjunior.gestao.tickets.controllers;

import com.github.robsonrjunior.gestao.tickets.model.TicketPriority;
import com.github.robsonrjunior.gestao.tickets.model.TicketStatus;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Named
@ApplicationScoped
public class EnumLabelBean implements Serializable {

    private ResourceBundle bundle;

    @PostConstruct
    public void init() {
        bundle = ResourceBundle.getBundle("messages");
    }

    public String statusLabel(TicketStatus status) {
        if (status == null) return "";
        return bundle.getString("ticket.status." + status.name());
    }

    public String priorityLabel(TicketPriority priority) {
        if (priority == null) return "";
        return bundle.getString("ticket.priority." + priority.name());
    }

    public List<SelectItem> getStatusSelectItems() {
        List<SelectItem> items = new ArrayList<>();
        for (TicketStatus s : TicketStatus.values()) {
            items.add(new SelectItem(s.name(), bundle.getString("ticket.status." + s.name())));
        }
        return items;
    }

    public List<SelectItem> getPrioritySelectItems() {
        List<SelectItem> items = new ArrayList<>();
        for (TicketPriority p : TicketPriority.values()) {
            items.add(new SelectItem(p.name(), bundle.getString("ticket.priority." + p.name())));
        }
        return items;
    }

    public String statusSeverity(TicketStatus status) {
        if (status == null) return "";
        return switch (status) {
            case OPEN -> "info";
            case IN_PROGRESS -> "warning";
            case CLOSED -> "success";
        };
    }

    public String prioritySeverity(TicketPriority priority) {
        if (priority == null) return "";
        return switch (priority) {
            case LOW -> "info";
            case MEDIUM -> "warning";
            case HIGH, CRITICAL -> "danger";
        };
    }
}
