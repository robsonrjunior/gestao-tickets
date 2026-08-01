package com.github.robsonrjunior.gestao.tickets.service;

import com.github.robsonrjunior.gestao.tickets.dto.TicketListItem;
import com.github.robsonrjunior.gestao.tickets.exception.ResourceNotFoundException;
import com.github.robsonrjunior.gestao.tickets.model.Ticket;
import com.github.robsonrjunior.gestao.tickets.model.TicketPriority;
import com.github.robsonrjunior.gestao.tickets.model.TicketStatus;
import com.github.robsonrjunior.gestao.tickets.model.User;
import com.github.robsonrjunior.gestao.tickets.repository.Page;
import com.github.robsonrjunior.gestao.tickets.repository.TicketRepository;
import com.github.robsonrjunior.gestao.tickets.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

@ApplicationScoped
public class TicketService {

    @Inject
    private TicketRepository repository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private Principal principal;

    public List<Ticket> list() {
        return repository.findAll();
    }

    public Page<TicketListItem> findPage(
        int first,
        int pageSize,
        Map<String, SortMeta> sortBy,
        Map<String, FilterMeta> filterBy
    ) {
        return repository.findPage(first, pageSize, sortBy, filterBy);
    }

    public Ticket get(Long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket not found: " + id));
    }

    @Transactional
    public Ticket create(Ticket ticket) {
        ticket.setId(null);
        if (ticket.getStatus() == null) {
            ticket.setStatus(TicketStatus.OPEN);
        }
        if (ticket.getPriority() == null) {
            ticket.setPriority(TicketPriority.MEDIUM);
        }
        if (ticket.getReporter() == null && principal != null && principal.getName() != null) {
            userRepository.findByUsername(principal.getName()).ifPresent(ticket::setReporter);
        }
        return repository.save(ticket);
    }

    @Transactional
    public Ticket update(Long id, Ticket ticket) {
        Ticket existing = get(id);
        ticket.setId(id);
        if (ticket.getReporter() == null) {
            ticket.setReporter(existing.getReporter());
        }
        return repository.save(ticket);
    }

    @Transactional
    public void delete(Long id) {
        Ticket ticket = get(id);
        repository.delete(ticket);
    }
}
