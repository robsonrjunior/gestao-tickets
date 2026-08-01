package com.github.robsonrjunior.gestao.tickets.service;

import com.github.robsonrjunior.gestao.tickets.dto.UserListItem;
import com.github.robsonrjunior.gestao.tickets.exception.DuplicateResourceException;
import com.github.robsonrjunior.gestao.tickets.exception.ResourceNotFoundException;
import com.github.robsonrjunior.gestao.tickets.model.User;
import com.github.robsonrjunior.gestao.tickets.repository.Page;
import com.github.robsonrjunior.gestao.tickets.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository repository;

    public List<User> list() {
        return repository.findAll();
    }

    public Page<UserListItem> findPage(
        int first,
        int pageSize,
        Map<String, SortMeta> sortBy,
        Map<String, FilterMeta> filterBy
    ) {
        return repository.findPage(first, pageSize, sortBy, filterBy);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User get(Long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }

    @Transactional
    public User create(User user) {
        user.setId(null);
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        checkUnique(user, null);
        user.setPassword(PasswordHasher.hash(user.getPassword()));
        return repository.save(user);
    }

    @Transactional
    public User update(Long id, User user) {
        User existing = get(id);
        checkUnique(user, id);
        user.setId(id);
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            user.setPassword(existing.getPassword());
        } else {
            user.setPassword(PasswordHasher.hash(user.getPassword()));
        }
        return repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        User user = get(id);
        repository.delete(user);
    }

    private void checkUnique(User user, Long currentId) {
        repository
            .findByUsername(user.getUsername())
            .filter(existing -> !existing.getId().equals(currentId))
            .ifPresent(existing -> {
                throw new DuplicateResourceException(
                    "Username already in use: " + user.getUsername()
                );
            });
        repository
            .findByEmail(user.getEmail())
            .filter(existing -> !existing.getId().equals(currentId))
            .ifPresent(existing -> {
                throw new DuplicateResourceException("Email already in use: " + user.getEmail());
            });
    }
}
