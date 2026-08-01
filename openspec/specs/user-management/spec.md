# User Management

## Purpose

CRUD de usuários (ADMIN), com username/email únicos, roles e seed do admin inicial.

## Requirements

### Requirement: User CRUD
The system SHALL provide user CRUD via REST and JSF for ADMIN only. A user SHALL have unique username, unique email, BCrypt password, role (`USER` | `ADMIN`), optional display name, `createdAt`, and `updatedAt`. Password hashes SHALL never appear in API responses or views.

#### Scenario: Create user
- **WHEN** an ADMIN creates a user with username, email, and password
- **THEN** the system hashes the password, persists the user, and returns HTTP 201 without the password

#### Scenario: Reject duplicates
- **WHEN** username or email already exists
- **THEN** the system returns HTTP 409

#### Scenario: Update and delete
- **WHEN** an ADMIN updates or deletes an existing user
- **THEN** the system applies the change (hashing a new password only when provided) and returns HTTP 200 or 204

### Requirement: Seed admin
On startup, if no ADMIN exists, the system SHALL create username `admin`, password `admin123` (BCrypt), displayName `Administrator`, email `admin@localhost`, role `ADMIN`.

#### Scenario: First startup
- **WHEN** the app starts with no ADMIN user
- **THEN** the seed admin is created once

#### Scenario: Later startups
- **WHEN** an ADMIN already exists
- **THEN** no duplicate admin is created
