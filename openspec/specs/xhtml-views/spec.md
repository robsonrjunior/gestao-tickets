# XHTML Views

## Purpose

Layout compartilhado e páginas principais de tickets e usuários com PrimeFaces e PrimeFlex.

## Requirements

### Requirement: Shared layout
The shared Facelets layout SHALL compile and render a consistent shell for application pages.

#### Scenario: Layout compiles
- **WHEN** JSF loads the master layout template
- **THEN** it compiles without Facelet errors

### Requirement: Primary views
Primary pages (`index.xhtml`, `ticket-list.xhtml`, `ticket.xhtml`, `user-list.xhtml`, `user.xhtml`, `dashboard.xhtml`, `meus-tickets.xhtml`) SHALL use the shared layout. Views SHALL prefer PrimeFaces components and PrimeFlex utilities.

#### Scenario: Ticket and user pages in shell
- **WHEN** a user opens ticket or user list/form pages
- **THEN** each renders inside the shared layout content area

#### Scenario: Home page
- **WHEN** a user opens `index.xhtml`
- **THEN** it renders inside the shared layout with Gestão Tickets branding

#### Scenario: Dashboard and Meus Tickets in shell
- **WHEN** an authorized user opens `dashboard.xhtml` or `meus-tickets.xhtml`
- **THEN** each renders inside the shared layout content area
