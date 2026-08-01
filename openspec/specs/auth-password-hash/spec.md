# Password Hashing

## Purpose

Armazenamento e verificação de senhas com BCrypt; hashes nunca expostos na UI ou API.

## Requirements

### Requirement: BCrypt storage
Passwords SHALL be stored as BCrypt hashes (work factor 12). Plaintext SHALL never be persisted.

#### Scenario: Hash on create or password change
- **WHEN** a user is created or updated with a new password
- **THEN** only the BCrypt hash is stored

#### Scenario: Keep hash when password blank on edit
- **WHEN** a user is updated with an empty password field
- **THEN** the existing hash is unchanged

### Requirement: No password exposure
Password hashes SHALL NOT appear in API responses or JSF views.

#### Scenario: API and views omit password
- **WHEN** a user is returned by API or rendered in a view
- **THEN** no password or hash is included

### Requirement: BCrypt verify
Login SHALL verify credentials with BCrypt against the stored hash.

#### Scenario: Correct and incorrect password
- **WHEN** login credentials are validated
- **THEN** a correct password succeeds and an incorrect password fails

### Requirement: Create vs edit password fields
Create form SHALL require password. Edit form SHALL offer optional new password.

#### Scenario: Forms differ
- **WHEN** ADMIN opens create vs edit user form
- **THEN** create requires password; edit has optional new password
