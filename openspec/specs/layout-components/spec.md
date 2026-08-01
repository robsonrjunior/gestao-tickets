# Layout Components

## Purpose

Shell Facelets reutilizável (topbar, navbar, footer) com PrimeFaces e PrimeFlex.

## Requirements

### Requirement: Shell components
The system SHALL provide Facelets includes for topbar, navbar, footer, and shell. Shell SHALL compose topbar, navbar, and a content slot. Styling SHALL use PrimeFlex utilities. Interactive chrome SHALL use PrimeFaces components (e.g. `p:megaMenu`).

#### Scenario: Shell structure
- **WHEN** shell renders
- **THEN** topbar, navbar, and content insertion point are present in a PrimeFlex flex layout

#### Scenario: Footer
- **WHEN** footer renders
- **THEN** it shows project attribution with PrimeFlex utility classes

### Requirement: Master layout
`layout.xhtml` SHALL wrap pages with shell and footer, load PrimeFlex locally via `h:outputStylesheet`, and MUST NOT load Bootstrap or external CDN CSS/JS.

#### Scenario: Page uses layout
- **WHEN** a page uses `layout.xhtml` and defines content
- **THEN** content appears inside the shell with footer at the bottom

### Requirement: Navigation menu
Navbar SHALL link to Tickets and (for ADMIN) Users via JSF navigation. No book/movie/series/rating entries.

#### Scenario: Tickets link
- **WHEN** the user selects Tickets
- **THEN** navigation goes to the ticket list view

#### Scenario: Users link for ADMIN
- **WHEN** an ADMIN selects Users
- **THEN** navigation goes to the user list view
