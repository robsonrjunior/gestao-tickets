# Role-Based Access Control

## Purpose

Controle de acesso com roles SOLICITANTE, SUPORTE, GESTOR e ADMIN para tickets, dashboard e usuários (sem catálogo de mídia).

## Requirements

### Requirement: Roles
Every user SHALL have exactly one role: `SOLICITANTE`, `SUPORTE`, `GESTOR`, or `ADMIN` (default `SOLICITANTE`). The role `USER` SHALL NOT exist. The identity store SHALL expose the role to the container for authorization checks.

#### Scenario: Assign role
- **WHEN** a user is created with or without an explicit role
- **THEN** the given role is stored, or `SOLICITANTE` if omitted

#### Scenario: USER role rejected
- **WHEN** code or data attempts to use role `USER`
- **THEN** it is not a valid role in the system

### Requirement: Admin-only pages
User management pages and admin-only actions SHALL require `ADMIN`. Non-admins get HTTP 403; unauthenticated users are redirected to login.

#### Scenario: ADMIN allowed
- **WHEN** an ADMIN opens user management
- **THEN** the page renders

#### Scenario: Non-admin denied
- **WHEN** a SOLICITANTE, SUPORTE, or GESTOR opens user management
- **THEN** access is denied (HTTP 403)

### Requirement: Role-aware navigation
Navbar SHALL show menu items according to role:
- **Meus Tickets** for authenticated users with role `SOLICITANTE` (and optionally others as defined by layout)
- **Tickets** (lista geral) for `SUPORTE`, `GESTOR`, and `ADMIN`
- **Dashboard** for `GESTOR` and `ADMIN`
- **Users** only for `ADMIN`

#### Scenario: GESTOR menu
- **WHEN** a GESTOR views the navbar
- **THEN** Dashboard and Tickets are visible and Users is not

#### Scenario: SOLICITANTE menu
- **WHEN** a SOLICITANTE views the navbar
- **THEN** Meus Tickets is visible and Users and Dashboard are not

#### Scenario: ADMIN menu
- **WHEN** an ADMIN views the navbar
- **THEN** Tickets, Dashboard, and Users are visible

#### Scenario: SUPORTE menu
- **WHEN** a SUPORTE views the navbar
- **THEN** Tickets is visible and Users and Dashboard are not

### Requirement: Topbar identity
The topbar SHALL show the authenticated user's display name (or username) and a logout action.

#### Scenario: Authenticated topbar
- **WHEN** an authenticated user views any shell page
- **THEN** identity and logout are shown

### Requirement: Dashboard access
The Dashboard page SHALL require role `GESTOR` or `ADMIN`. Other authenticated roles get HTTP 403; unauthenticated users are redirected to login.

#### Scenario: GESTOR opens dashboard
- **WHEN** a GESTOR opens the dashboard page
- **THEN** the page renders

#### Scenario: SOLICITANTE denied dashboard
- **WHEN** a SOLICITANTE opens the dashboard page
- **THEN** access is denied (HTTP 403)

### Requirement: Meus Tickets access
The Meus Tickets page SHALL be accessible to authenticated users with role `SOLICITANTE` (at minimum). Unauthenticated users are redirected to login.

#### Scenario: SOLICITANTE opens meus tickets
- **WHEN** a SOLICITANTE opens the Meus Tickets page
- **THEN** the page renders
