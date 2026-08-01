package com.github.robsonrjunior.gestao.tickets.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seeder_execution")
@Getter
@Setter
public class SeederExecution {

    @Id
    private Long id = 1L;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime seededAt;
}
