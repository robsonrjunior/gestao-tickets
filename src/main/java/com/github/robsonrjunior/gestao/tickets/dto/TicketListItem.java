package com.github.robsonrjunior.gestao.tickets.dto;

import com.github.robsonrjunior.gestao.tickets.model.TicketPriority;
import com.github.robsonrjunior.gestao.tickets.model.TicketStatus;
import java.time.LocalDateTime;

public record TicketListItem(
    Long id,
    String title,
    TicketStatus status,
    TicketPriority priority,
    String assigneeName,
    String reporterName,
    LocalDateTime createdAt
) {}
