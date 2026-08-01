# Meus Tickets

## Purpose

Placeholder Meus Tickets screen for SOLICITANTE to later list and track their own tickets; content is intentionally empty (TODO) in this change.

## Requirements

### Requirement: Meus Tickets placeholder page
The system SHALL provide a `meus-tickets.xhtml` page that uses the shared layout, is titled for Meus Tickets, and shows a clear TODO/placeholder message indicating that content will be implemented later. The page SHALL NOT list or filter tickets in this change.

#### Scenario: Empty meus tickets renders
- **WHEN** an authorized user opens the Meus Tickets page
- **THEN** the page renders inside the shared layout with a visible TODO/placeholder and no ticket list
