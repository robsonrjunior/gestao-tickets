---
name: primeflex-setup
description: >-
  PrimeFlex 3.3.1 installation, configuration, and core concepts for
  Jakarta EE (Faces 4, PrimeFaces) applications. USE FOR:
  installation, CDN, npm import, theming, breakpoints, responsive prefixes
  (sm:, md:, lg:, xl:), state variants (hover:, focus:, active:), spacing
  scale, SASS variables, CSS variables, purge/production size, styleclass
  mixin, PrimeFlex setup questions. Do NOT use for specific utility class
  reference — see the per-family skills (grid, flexbox, spacing, sizing,
  typography, colors, border, background, effects, motion).
---

# PrimeFlex 3.3.1 — Setup & core concepts

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. Apply PrimeFlex classes via `styleClass` on
`p:` components or `class` on plain Facelets markup. See
`.opencode/skills/primeflex/CONVENTIONS.md`.

PrimeFlex is a CSS utility library derived from the Prime UI theme.
When bundled with PrimeFaces it ships with the PrimeFaces theme; standalone
use requires including a theme CSS file.

## Installation

**npm**

```bash
npm install primeflex
```

Then import in your stylesheet:

```css
@import 'primeflex/primeflex.css';
```

**CDN**

```xhtml
<link rel="stylesheet" href="https://unpkg.com/primeflex@latest/primeflex.css"/>
```

**Standalone themes** (not needed with PrimeFaces)

```
primeflex/themes/primeone-light.css
primeflex/themes/primeone-dark.css
```

**Production optimization** — use PurgeCSS to strip unused classes.

**SASS customization** — clone the repo, modify variables, rebuild
`primeflex.scss`.

**Reuse class blocks via `styleclass` mixin:**

```scss
@import 'primeflex/primeflex.scss';

.mybutton {
    @include styleclass('bg-blue-500 hover:bg-blue-600 border-round transition-colors transition-duration-150 p-3 border-none');
}
```

## SASS variables

| Variable | Description | Default |
|---|---|---|
| `$sm` | Breakpoint for small screens (phones) | `576px` |
| `$md` | Breakpoint for medium screens (tablets) | `768px` |
| `$lg` | Breakpoint for large screens (notebooks) | `992px` |
| `$xl` | Breakpoint for larger screens (monitors) | `1200px` |
| `$gutter` | Grid column padding | `.5rem` |
| `$fieldMargin` | Field spacing (vertical/horizontal depending on layout) | `1rem` |
| `$fieldLabelMargin` | Field label spacing | `.5rem` |
| `$helperTextMargin` | Top spacing of helper text | `.25rem` |
| `$spacer` | Base spacing unit for p-*/m-* utilities | `1rem` |
| `$separator` | Separator between responsive breakpoints and pseudo-classes (`:`) | `:` |

## Responsive breakpoints

Mobile-first min-width media queries. Prefix a class with `sm:`, `md:`,
`lg:`, or `xl:` to apply it only at that breakpoint and above.

| Prefix | Min width | Target |
|---|---|---|
| `sm:` | ≥576px | Phones |
| `md:` | ≥768px | Tablets |
| `lg:` | ≥992px | Notebooks |
| `xl:` | ≥1200px | Monitors |

Grid, spacing, sizing, flexbox, and most utilities support responsive
prefixes. Prefixes combine: `class="col-12 md:col-6 lg:col-3"`.

## State variants

| Prefix | Applies when |
|---|---|
| `hover:` | Cursor hovers over element |
| `focus:` | Element has focus |
| `active:` | Element is being activated |

State variants are supported by color utilities (text, background, border)
and style utilities (opacity, cursor, etc.), not layout utilities.

## Spacing scale

All `p-*` (padding) and `m-*` (margin) utilities use these factors:

| Index | Multiplier | Value (with $spacer=1rem) |
|---|---|---|
| 0 | 0 | 0 |
| 1 | 0.25 | 0.25rem |
| 2 | 0.5 | 0.5rem |
| 3 | 1 | 1rem |
| 4 | 1.5 | 1.5rem |
| 5 | 2 | 2rem |
| 6 | 3 | 3rem |
| 7 | 4 | 4rem |
| 8 | 5 | 5rem |

Class pattern: `p-{index}` / `m-{index}`, directional: `p{t|r|b|l|x|y}-{index}`,
`m{t|r|b|l|x|y}-{index}`. Negative margins: `-m-{1..8}`.

## Theming — CSS variables

### Surface colors (background layers)

`--surface-0`, `--surface-50`, `--surface-100`, `--surface-200`,
`--surface-300`, `--surface-400`, `--surface-500`, `--surface-600`,
`--surface-700`, `--surface-800`, `--surface-900`

Surfaces invert between light/dark modes; use for background layering.

### Color palette (13 colors × 10 tints)

**Colors:** blue, green, yellow, cyan, pink, indigo, teal, orange,
bluegray, purple, red, gray, primary.

**Tints:** 50, 100, 200, 300, 400, 500, 600, 700, 800, 900.

Each is available as `--{color}-{tint}`, e.g. `--blue-500`, `--primary-700`.

### Core theme variables

| Variable | Purpose |
|---|---|
| `--primary-color` | Primary accent color |
| `--primary-color-text` | Text color on primary backgrounds |
| `--text-color` | Body text color |
| `--text-color-secondary` | Secondary text |
| `--border-radius` | Default border radius |
| `--surface-ground` | Page background |
| `--surface-section` | Section background |
| `--surface-card` | Card background |
| `--surface-overlay` | Overlay/dropdown background |
| `--surface-border` | Border color |
| `--surface-hover` | Hover background |

## XHTML usage

```xhtml
<p:commandButton value="Save"
    styleClass="bg-primary border-none text-white p-3 border-round-lg mb-3 hover:bg-primary-600 w-full md:w-auto"/>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/installation/` — CDN, npm, variables, themes, production size, reuse classes
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/theming/` — color palette, surface colors, theme variables
- `primeflex-3.3.1/primeflex-3.3.1/styles/lib/core/_variables.scss` — SASS defaults
- `primeflex-3.3.1/primeflex-3.3.1/styles/lib/core/_spacing.scss` — spacing scale
