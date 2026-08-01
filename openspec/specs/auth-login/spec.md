# Authentication & Login

## Purpose

Login/logout com Jakarta EE Security, páginas públicas e timeout de sessão de 30 minutos.

## Requirements

### Requirement: Login
The system SHALL authenticate via Jakarta EE Security form login. Success establishes a session and redirects home; failure shows an error and stays on the login page. Unauthenticated access to protected pages SHALL redirect to login.

#### Scenario: Valid credentials
- **WHEN** a user submits valid username and password
- **THEN** a session is established and the user is redirected to the home page

#### Scenario: Invalid credentials
- **WHEN** username or password is wrong
- **THEN** an error message is shown and the user remains on the login page

### Requirement: Logout
The system SHALL invalidate the session and redirect to the login page on logout.

#### Scenario: Logout action
- **WHEN** an authenticated user logs out
- **THEN** the session ends and the login page is shown

### Requirement: Public pages
`/login.xhtml`, `/jakarta.faces.resource/*`, and `/resources/*` SHALL be accessible without authentication.

#### Scenario: Login page without session
- **WHEN** an unauthenticated user opens `/login.xhtml`
- **THEN** the login form renders without redirect

### Requirement: Session timeout
HTTP session timeout SHALL be 30 minutes. After expiry, the next protected request redirects to login.

#### Scenario: Idle timeout
- **WHEN** the session is idle for 30 minutes
- **THEN** the next protected request redirects to login
