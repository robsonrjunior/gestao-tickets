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

### Requirement: Stable component ids for e2e
Interactive primary controls used by automated UI tests SHALL declare explicit Facelets `id` attributes so client IDs are stable across builds (not auto-generated `j_idt*`). At minimum this includes: login form and its submit control, logout form/control, ticket and user list "Novo" actions, and primary form actions Salvar / Cancelar / Editar / Voltar on ticket and user forms.

#### Scenario: Login form has stable ids
- **WHEN** the login page is rendered
- **THEN** the login form and its primary submit control have explicit ids usable as stable Selenium locators

#### Scenario: Primary ticket and user actions have stable ids
- **WHEN** ticket or user list/form pages are rendered for an authorized user
- **THEN** Novo, Salvar, Cancelar, Editar, and Voltar action components that exist on the page have explicit ids
