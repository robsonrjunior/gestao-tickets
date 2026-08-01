# Docker Compose

## Purpose

MySQL 9 via Docker Compose para desenvolvimento local, alinhado ao `.env-example`.

## Requirements

### Requirement: MySQL via Compose
The project SHALL provide `docker-compose.utils.yml` starting MySQL 9 with database `gestao_tickets`, port 3306, credentials aligned with `.env-example`, a named volume for data persistence, and attachment to the shared Docker network `gestao-tickets`.

#### Scenario: Start database
- **WHEN** a developer runs `docker compose -f docker-compose.utils.yml up -d`
- **THEN** MySQL 9 starts with `gestao_tickets` ready on port 3306

#### Scenario: Env alignment
- **WHEN** compose env vars are compared to `.env-example`
- **THEN** database name, user, and password match application expectations

#### Scenario: Shared network
- **WHEN** utils compose is started
- **THEN** the MySQL service joins the Docker network named `gestao-tickets`

### Requirement: Utils compose file
The project SHALL keep infrastructure utilities (starting with MySQL) in `docker-compose.utils.yml`, separate from the application compose file.

#### Scenario: Utilities without app
- **WHEN** a developer runs only the utils compose
- **THEN** MySQL starts and no application container is created
