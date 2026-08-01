# Ticket Management

## Purpose

CRUD de tickets de suporte com listagem paginada, prioridade, status e atribuição a usuários.

## Requirements

### Requirement: Ticket CRUD
The system SHALL provide ticket CRUD via REST and JSF. Any authenticated user MAY create and view tickets. Only ADMIN SHALL edit or delete. A ticket SHALL have title, description, status (`OPEN` | `IN_PROGRESS` | `CLOSED`), priority (`LOW` | `MEDIUM` | `HIGH` | `CRITICAL`, default `MEDIUM`), optional assignee (User), reporter (current user on create), `createdAt`, and `updatedAt`.

#### Scenario: Create ticket
- **WHEN** an authenticated user submits a ticket with non-empty title and description
- **THEN** the system sets reporter to the current user, status to `OPEN`, timestamps to now, persists it, and returns HTTP 201

#### Scenario: Reject invalid ticket
- **WHEN** a client submits a ticket with blank title
- **THEN** the system rejects with HTTP 400 and does not persist

#### Scenario: Admin updates ticket
- **WHEN** an ADMIN updates title, description, status, priority, or assignee
- **THEN** the system updates `updatedAt` and returns HTTP 200

#### Scenario: Non-admin cannot edit or delete
- **WHEN** a non-ADMIN tries to update or delete a ticket
- **THEN** the system returns HTTP 403

### Requirement: Ticket listing
The system SHALL list tickets with server-side pagination, sorting, and filters (status, priority, text on title/description) via REST and JSF.

#### Scenario: Paginated list
- **WHEN** a client requests a page with offset, size, and optional filters
- **THEN** the system returns that page and the total matching count

### Requirement: Ticket UI with PrimeFaces
Ticket list and form views SHALL use PrimeFaces components (e.g. `p:dataTable` lazy, `p:selectOneMenu`, `p:commandButton`) and PrimeFlex utility classes for layout. Edit/delete actions SHALL be visible only to ADMIN.

#### Scenario: List page
- **WHEN** the ticket list page loads
- **THEN** it renders a PrimeFaces DataTable with ticket columns and role-appropriate actions

#### Scenario: Form page
- **WHEN** a user opens the ticket form in create or edit mode
- **THEN** fields use PrimeFaces inputs; non-admins see read-only view mode
