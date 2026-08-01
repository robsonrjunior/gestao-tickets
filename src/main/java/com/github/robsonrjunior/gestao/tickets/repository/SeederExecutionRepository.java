package com.github.robsonrjunior.gestao.tickets.repository;

import com.github.robsonrjunior.gestao.tickets.model.SeederExecution;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

@ApplicationScoped
public class SeederExecutionRepository {

    @PersistenceContext(unitName = "gestaoTicketsPU")
    private EntityManager em;

    public Optional<SeederExecution> findByName(String name) {
        return em.createQuery(
                "SELECT s FROM SeederExecution s WHERE s.name = :name", SeederExecution.class)
            .setParameter("name", name)
            .getResultStream()
            .findFirst();
    }

    public void save(SeederExecution execution) {
        if (em.find(SeederExecution.class, execution.getId()) == null) {
            em.persist(execution);
        } else {
            em.merge(execution);
        }
    }
}
