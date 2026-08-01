package com.github.robsonrjunior.gestao.tickets.repository;

import com.github.robsonrjunior.gestao.tickets.dto.UserListItem;
import com.github.robsonrjunior.gestao.tickets.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
public class UserRepository {

    private static final ProjectionSpec<User, UserListItem> LIST_PROJECTION = new ProjectionSpec<>() {
        @Override
        public Class<UserListItem> projectionType() {
            return UserListItem.class;
        }

        @Override
        public List<Selection<?>> selections(Root<User> root) {
            return List.of(
                root.get("id"),
                root.get("username"),
                root.get("email"),
                root.get("displayName"),
                root.get("role"),
                root.get("createdAt")
            );
        }

        @Override
        public Set<String> filterableFields() {
            return Set.of("username", "email", "displayName");
        }

        @Override
        public Set<String> sortableFields() {
            return Set.of("username", "email", "displayName");
        }

        @Override
        public Set<String> globalFilterFields() {
            return Set.of("username", "email", "displayName");
        }
    };

    @PersistenceContext(unitName = "gestaoTicketsPU")
    private EntityManager em;

    @Inject
    private Instance<PageableQuery> pageableQuery;

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    public Optional<User> findByUsername(String username) {
        return single(
            em
                .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
        );
    }

    public Optional<User> findByEmail(String email) {
        return single(
            em
                .createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
        );
    }

    public Page<UserListItem> findPage(
        int first,
        int pageSize,
        Map<String, SortMeta> sortBy,
        Map<String, FilterMeta> filterBy
    ) {
        return pageableQuery.get().findPage(em, User.class, first, pageSize, sortBy, filterBy, LIST_PROJECTION);
    }

    private Optional<User> single(jakarta.persistence.TypedQuery<User> query) {
        try {
            return Optional.of(query.setMaxResults(1).getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
