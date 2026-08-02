package com.github.robsonrjunior.gestao.tickets.configs;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Startup;
import jakarta.enterprise.context.ApplicationScoped;

@DataSourceDefinition(
    name = "java:app/GestaoTickets/GestaoTicketsDataSource",
    className = "com.mysql.cj.jdbc.MysqlDataSource",
    user = "${db.user}",
    password = "${db.password}",
    url = "${db.url}"
)
@ApplicationScoped
@Startup
public class DatabaseConfiguration {}
