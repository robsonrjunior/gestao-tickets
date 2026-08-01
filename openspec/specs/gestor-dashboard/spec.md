# Gestor Dashboard

## Purpose

Placeholder Dashboard screen for GESTOR (and ADMIN) to later view operational metrics and ticket overview; content is intentionally empty (TODO) in this change.

## Requirements

### Requirement: Dashboard placeholder page
The system SHALL provide a `dashboard.xhtml` page that uses the shared layout, is titled for Dashboard, and shows a clear TODO/placeholder message indicating that content will be implemented later. The page SHALL NOT implement charts, KPIs, or ticket aggregations in this change.

#### Scenario: Empty dashboard renders
- **WHEN** an authorized user opens the Dashboard page
- **THEN** the page renders inside the shared layout with a visible TODO/placeholder and no operational widgets
