# Docker Compose App

## Purpose

Docker Compose da aplicação gestao-tickets: build a partir do Dockerfile, exposição HTTP e conexão ao MySQL via rede compartilhada com os utilitários.

## Requirements

### Requirement: Application compose file
The project SHALL provide `docker-compose.yml` that builds and runs the application image from the project `Dockerfile`, publishes port 8080, loads environment from `.env`, and joins the Docker network named `gestao-tickets`.

#### Scenario: Start application
- **WHEN** a developer runs `docker compose up -d` after building the WAR (`make package`) and with utils already up
- **THEN** the application container starts and is reachable on port 8080

#### Scenario: Env file
- **WHEN** the application service starts
- **THEN** it loads variables from `.env` (or equivalent env_file configuration)

### Requirement: Database host override in compose
When running via application compose on the shared network, the service SHALL set `MYSQL_HOST` to the MySQL service name (`mysql`) so the app reaches the database container.

#### Scenario: App reaches MySQL on compose network
- **WHEN** both utils and app composes are running on network `gestao-tickets`
- **THEN** the application uses `MYSQL_HOST=mysql` and connects to the MySQL service without relying on localhost

### Requirement: App without rebuilding utils
Starting the application compose SHALL NOT start or rebuild utility services defined only in `docker-compose.utils.yml`.

#### Scenario: App-only up
- **WHEN** a developer runs `docker compose up -d` without the utils file
- **THEN** only the application service is managed by that command
