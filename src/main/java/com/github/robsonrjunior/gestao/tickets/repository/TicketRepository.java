package com.github.robsonrjunior.gestao.tickets.repository;

import com.github.robsonrjunior.gestao.tickets.dto.TicketListItem;
import com.github.robsonrjunior.gestao.tickets.model.Ticket;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

@ApplicationScoped
public class TicketRepository {

    private static final ProjectionSpec<Ticket, TicketListItem> LIST_PROJECTION = new ProjectionSpec<>() {
        @Override
        public Class<TicketListItem> projectionType() {
            return TicketListItem.class;
        }

        @Override
        public List<Selection<?>> selections(Root<Ticket> root) {
            return List.of(
                root.get("id"),
                root.get("title"),
                root.get("status"),
                root.get("priority"),
                root.get("assignee").get("displayName"),
                root.get("reporter").get("displayName"),
                root.get("createdAt")
            );
        }

        @Override
        public Set<String> filterableFields() {
            return Set.of("title", "status", "priority");
        }

        @Override
        public Set<String> sortableFields() {
            return Set.of("title", "status", "priority", "createdAt");
        }

        @Override
        public Set<String> globalFilterFields() {
            return Set.of("title", "description");
        }
    };

    @PersistenceContext(unitName = "gestaoTicketsPU")
    private EntityManager em;

    @Inject
    private Instance<PageableQuery> pageableQuery;

    public List<Ticket> findAll() {
        return em.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
    }

    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(em.find(Ticket.class, id));
    }

    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null) {
            em.persist(ticket);
            return ticket;
        }
        return em.merge(ticket);
    }

    public void delete(Ticket ticket) {
        em.remove(em.contains(ticket) ? ticket : em.merge(ticket));
    }

    public Page<TicketListItem> findPage(
        int first,
        int pageSize,
        Map<String, SortMeta> sortBy,
        Map<String, FilterMeta> filterBy
    ) {
        return pageableQuery.get().findPage(em, Ticket.class, first, pageSize, sortBy, filterBy, LIST_PROJECTION);
    }
}
