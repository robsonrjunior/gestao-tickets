package com.github.robsonrjunior.gestao.tickets.configs;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Startup;
import jakarta.enterprise.context.ApplicationScoped;

@DataSourceDefinition(
    name = "java:app/GestaoTickets/GestaoTicketsDataSource",
    className = "com.mysql.cj.jdbc.MysqlDataSource",
    user = "${ENV=MYSQL_USER}",
    password = "${ENV=MYSQL_PASSWORD}",
    url = "jdbc:mysql://${ENV=MYSQL_HOST}:${ENV=MYSQL_PORT}/${ENV=MYSQL_DATABASE}?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
)
@ApplicationScoped
@Startup
public class DatabaseConfiguration {}
