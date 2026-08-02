package com.github.robsonrjunior.gestao.tickets.configs;

import com.github.robsonrjunior.gestao.tickets.model.Role;
import com.github.robsonrjunior.gestao.tickets.model.SeederExecution;
import com.github.robsonrjunior.gestao.tickets.model.Ticket;
import com.github.robsonrjunior.gestao.tickets.model.TicketPriority;
import com.github.robsonrjunior.gestao.tickets.model.TicketStatus;
import com.github.robsonrjunior.gestao.tickets.model.User;
import com.github.robsonrjunior.gestao.tickets.repository.SeederExecutionRepository;
import com.github.robsonrjunior.gestao.tickets.repository.TicketRepository;
import com.github.robsonrjunior.gestao.tickets.repository.UserRepository;
import com.github.robsonrjunior.gestao.tickets.service.PasswordHasher;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class DatabaseSeeder {

    private static final Logger LOG = Logger.getLogger(DatabaseSeeder.class.getName());

    @Inject
    private UserRepository userRepository;

    @Inject
    private TicketRepository ticketRepository;

    @Inject
    private SeederExecutionRepository configRepository;

    @Transactional
    public void onStartup(@Observes @Initialized(ApplicationScoped.class) Object event) {
        if (configRepository.findByName("gestao-tickets-initial").isEmpty()) {
            seedAdmin();
            seedUsers();
            seedTickets();
            SeederExecution execution = new SeederExecution();
            execution.setName("gestao-tickets-initial");
            execution.setSeededAt(LocalDateTime.now());
            configRepository.save(execution);
            LOG.info("Seed: database seeding completed");
        } else {
            LOG.info("Seed: database already seeded, skipping initial seed");
        }
        ensureRoleUsers();
    }

    private void seedAdmin() {
        List<User> admins = userRepository
            .findAll()
            .stream()
            .filter(u -> u.getRole() == Role.ADMIN)
            .toList();

        if (!admins.isEmpty()) {
            LOG.info("Seed: ADMIN user already exists, skipping creation");
            return;
        }

        User admin = new User();
        admin.setUsername("admin");
        admin.setEmail("admin@localhost");
        admin.setDisplayName("Administrator");
        admin.setPassword(PasswordHasher.hash("admin123"));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);
        LOG.info("Seed: ADMIN user created - admin");
    }

    private void seedUsers() {
        UserData[] users = {
            new UserData("alice", "alice@email.com", "Alice Silva", "alice123", Role.SOLICITANTE),
            new UserData("bruno", "bruno@email.com", "Bruno Costa", "bruno123", Role.SOLICITANTE),
            new UserData("camila", "camila@email.com", "Camila Oliveira", "camila123", Role.SOLICITANTE),
            new UserData("diego", "diego@email.com", "Diego Santos", "diego123", Role.SOLICITANTE),
            new UserData("eliane", "eliane@email.com", "Eliane Ferreira", "eliane123", Role.SOLICITANTE),
            new UserData("suporte", "suporte@email.com", "Suporte User", "suporte123", Role.SUPORTE),
            new UserData("gestor", "gestor@email.com", "Gestor User", "gestor123", Role.GESTOR),
        };

        for (UserData data : users) {
            createUserIfMissing(data);
        }

        LOG.info("Seed: users seeding completed");
    }

    private void ensureRoleUsers() {
        createUserIfMissing(new UserData("suporte", "suporte@email.com", "Suporte User", "suporte123", Role.SUPORTE));
        createUserIfMissing(new UserData("gestor", "gestor@email.com", "Gestor User", "gestor123", Role.GESTOR));
    }

    private void createUserIfMissing(UserData data) {
        try {
            if (
                userRepository.findByUsername(data.username).isEmpty() &&
                userRepository.findByEmail(data.email).isEmpty()
            ) {
                User user = new User();
                user.setUsername(data.username);
                user.setEmail(data.email);
                user.setDisplayName(data.displayName);
                user.setPassword(PasswordHasher.hash(data.password));
                user.setRole(data.role);
                userRepository.save(user);
                LOG.info("Seed: user created - " + data.username + " (" + data.role + ")");
            } else {
                LOG.info("Seed: user already exists - " + data.username);
            }
        } catch (Exception e) {
            LOG.warning("Seed: failed to create user '" + data.username + "' - " + e.getMessage());
        }
    }

    private void seedTickets() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            LOG.info("Seed: tickets skipped - no users available");
            return;
        }

        User alice = findUser(users, "alice");
        User bruno = findUser(users, "bruno");
        User camila = findUser(users, "camila");
        User admin = findUser(users, "admin");

        TicketData[] tickets = {
            new TicketData("Configurar banco de dados", "Criar e configurar o banco de dados MySQL para o projeto", TicketStatus.OPEN, TicketPriority.HIGH, alice),
            new TicketData("Implementar autenticacao", "Desenvolver o modulo de login com Jakarta Security", TicketStatus.IN_PROGRESS, TicketPriority.CRITICAL, bruno),
            new TicketData("Criar interface de tickets", "Desenvolver a interface web para gerenciamento de tickets", TicketStatus.OPEN, TicketPriority.MEDIUM, camila),
            new TicketData("Corrigir bug no formulario", "O botao salvar nao funciona no Firefox", TicketStatus.OPEN, TicketPriority.HIGH, bruno),
            new TicketData("Adicionar testes unitarios", "Criar cobertura de testes para o modulo de tickets", TicketStatus.OPEN, TicketPriority.MEDIUM, null),
            new TicketData("Atualizar documentacao", "Documentar as APIs REST no README", TicketStatus.IN_PROGRESS, TicketPriority.LOW, admin),
            new TicketData("Migrar para Jakarta EE 11", "Atualizar todas as dependencias para Jakarta EE 11", TicketStatus.CLOSED, TicketPriority.CRITICAL, admin),
            new TicketData("Implementar busca global", "Adicionar busca por texto nos campos title e description", TicketStatus.OPEN, TicketPriority.LOW, alice),
        };

        for (TicketData data : tickets) {
            try {
                Ticket ticket = new Ticket();
                ticket.setTitle(data.title);
                ticket.setDescription(data.description);
                ticket.setStatus(data.status);
                ticket.setPriority(data.priority);
                ticket.setReporter(data.assignee != null ? data.assignee : admin);
                ticket.setAssignee(data.assignee);
                ticketRepository.save(ticket);
                LOG.info("Seed: ticket created - " + data.title);
            } catch (Exception e) {
                LOG.warning("Seed: failed to create ticket '" + data.title + "' - " + e.getMessage());
            }
        }

        LOG.info("Seed: tickets seeding completed");
    }

    private User findUser(List<User> users, String username) {
        return users
            .stream()
            .filter(u -> username.equals(u.getUsername()))
            .findFirst()
            .orElse(null);
    }

    private record UserData(String username, String email, String displayName, String password, Role role) {}

    private record TicketData(
        String title,
        String description,
        TicketStatus status,
        TicketPriority priority,
        User assignee
    ) {}
}
