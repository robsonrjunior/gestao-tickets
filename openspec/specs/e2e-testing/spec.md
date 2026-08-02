# E2E Testing

## Purpose

Garante cobertura e2e automatizada da UI JSF/PrimeFaces com JUnit e Selenium, validando fluxos críticos de autenticação, tickets, usuários e RBAC antes de regressões.

## Requirements

### Requirement: E2E test suite infrastructure
The project SHALL provide an automated end-to-end test suite under `src/test` that drives the running application UI with a browser via Selenium, using PrimeFaces-aware helpers (primefaces-selenium) and JUnit 5. The suite MUST be invocable via Maven (Failsafe integration-test phase or equivalent documented goal).

#### Scenario: Suite is runnable
- **WHEN** the application and MySQL are available at the configured base URL and the e2e Maven goal is executed
- **THEN** the suite starts a browser, runs the e2e tests, and reports pass/fail without requiring manual UI interaction

#### Scenario: Base URL is configurable
- **WHEN** the base URL is supplied via system property or environment variable
- **THEN** all e2e tests target that URL (default suitable for local Payara Micro on port 8080)

### Requirement: Authentication e2e coverage
The e2e suite SHALL cover login success, login failure, logout, and redirect of unauthenticated access to a protected page.

#### Scenario: Valid login
- **WHEN** a seeded user submits valid credentials on the login page
- **THEN** the browser lands on the authenticated home page

#### Scenario: Invalid login
- **WHEN** a user submits invalid credentials
- **THEN** the browser remains on the login page and an error message is shown

#### Scenario: Logout
- **WHEN** an authenticated user triggers logout
- **THEN** the session ends and the login page is shown

#### Scenario: Protected page without session
- **WHEN** an unauthenticated client opens a protected page URL
- **THEN** the client is sent to the login page

### Requirement: Ticket management e2e coverage
The e2e suite SHALL cover ticket list access and admin ticket create, view, edit, and delete flows against the UI.

#### Scenario: Admin opens ticket list
- **WHEN** an ADMIN user is logged in and opens the ticket list page
- **THEN** the tickets data table is visible

#### Scenario: Admin creates a ticket
- **WHEN** an ADMIN user creates a ticket with a valid title via the UI
- **THEN** the ticket appears on the list after save

#### Scenario: Admin views and edits a ticket
- **WHEN** an ADMIN user opens an existing ticket in view mode and then saves an edit
- **THEN** the updated data is reflected on the list or form

#### Scenario: Admin deletes a ticket
- **WHEN** an ADMIN user confirms deletion of a ticket from the list
- **THEN** the ticket is no longer shown in the list

#### Scenario: Title validation on create
- **WHEN** a user attempts to save a new ticket with a blank title
- **THEN** a validation message is shown and the ticket is not created

### Requirement: User management e2e coverage
The e2e suite SHALL cover admin user list access and user create, view, and edit flows against the UI.

#### Scenario: Admin opens user list
- **WHEN** an ADMIN user is logged in and opens the user list page
- **THEN** the users data table is visible

#### Scenario: Admin creates a user
- **WHEN** an ADMIN user creates a user with unique username, email, password, and role via the UI
- **THEN** the user appears on the list after save

#### Scenario: Admin views and edits a user
- **WHEN** an ADMIN user opens an existing user in view mode and then saves an edit
- **THEN** the updated data is reflected on the list or form

### Requirement: RBAC e2e coverage
The e2e suite SHALL verify role-based navigation visibility and denied access to admin-only pages for non-admin roles.

#### Scenario: Solicitante navigation
- **WHEN** a SOLICITANTE user is logged in
- **THEN** the navbar exposes Meus Tickets and does not expose Usuários as an available admin destination

#### Scenario: Non-admin denied user pages
- **WHEN** a non-ADMIN authenticated user requests `/user-list.xhtml` directly
- **THEN** access is denied (HTTP 403 or equivalent forbidden outcome)

#### Scenario: Admin sees full navigation
- **WHEN** an ADMIN user is logged in
- **THEN** the navbar exposes ticket list and user management entries

### Requirement: Seed credentials for e2e
E2E tests MUST use known seeded credentials (at minimum `admin` / `admin123` and one SOLICITANTE such as `alice` / `alice123`). If SUPORTE or GESTOR scenarios are included, the suite MUST obtain those users via seed data or a documented setup step.

#### Scenario: Admin seed login works in e2e
- **WHEN** the e2e suite logs in with the seeded admin credentials
- **THEN** authentication succeeds against the running application database
