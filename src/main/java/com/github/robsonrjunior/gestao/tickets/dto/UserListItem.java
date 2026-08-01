package com.github.robsonrjunior.gestao.tickets.dto;

import com.github.robsonrjunior.gestao.tickets.model.Role;
import java.time.LocalDateTime;

public record UserListItem(
    Long id,
    String username,
    String email,
    String displayName,
    Role role,
    LocalDateTime createdAt
) {}