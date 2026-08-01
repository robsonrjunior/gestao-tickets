# Role-Based Access Control

## Purpose

Controle de acesso com roles USER e ADMIN para tickets e usuários (sem catálogo de mídia).

## Requirements

### Requirement: Roles
Every user SHALL have exactly one role: `USER` or `ADMIN` (default `USER`). The identity store SHALL expose the role to the container for authorization checks.

#### Scenario: Assign role
- **WHEN** a user is created with or without an explicit role
- **THEN** the given role is stored, or `USER` if omitted

### Requirement: Admin-only pages
User management pages and admin-only actions SHALL require `ADMIN`. Non-admins get HTTP 403; unauthenticated users are redirected to login.

#### Scenario: ADMIN allowed
- **WHEN** an ADMIN opens user management
- **THEN** the page renders

#### Scenario: USER denied
- **WHEN** a USER opens user management
- **THEN** access is denied (HTTP 403)

### Requirement: Role-aware navigation
Navbar SHALL show Tickets to all authenticated users and Users only to ADMIN. No media-catalog menu items.

#### Scenario: ADMIN menu
- **WHEN** an ADMIN views the navbar
- **THEN** Tickets and Users are visible

#### Scenario: USER menu
- **WHEN** a USER views the navbar
- **THEN** Tickets is visible and Users is not

### Requirement: Topbar identity
The topbar SHALL show the authenticated user's display name (or username) and a logout action.

#### Scenario: Authenticated topbar
- **WHEN** an authenticated user views any shell page
- **THEN** identity and logout are shown
