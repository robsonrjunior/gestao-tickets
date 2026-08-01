# PrimeFlex Styling

## Purpose

PrimeFlex como único framework de utilitários CSS; UI interativa com PrimeFaces.

## Requirements

### Requirement: PrimeFlex only
The application SHALL use PrimeFlex (locally served) as the only utility CSS framework. Bootstrap CSS/JS MUST NOT be loaded. Layout, spacing, sizing, typography, color, and border utilities in XHTML SHALL use PrimeFlex class names. Interactive UI SHALL prefer PrimeFaces components (`p:` tags).

#### Scenario: Layout loads PrimeFlex
- **WHEN** the master layout is inspected
- **THEN** it loads PrimeFlex via `h:outputStylesheet` and has no Bootstrap or CDN utility CSS

#### Scenario: No Bootstrap classes
- **WHEN** XHTML views are reviewed
- **THEN** they do not use Bootstrap-only utility class names
