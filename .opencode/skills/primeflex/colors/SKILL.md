---
name: primeflex-colors
description: >-
  How to build PrimeFlex 3.3.1 color utilities correctly, sourced from the
  vendored docs. USE FOR: text color, background color, border color, color
  palettes, surface colors, alpha variants, hover/focus/active color
  variants — applying semantic and palette-based color classes in JSF/Facelets
  views.
---

# PrimeFlex color utilities

PrimeFlex 3.3.1 CSS utility classes for colors in JSF/Facelets views.
Namespaces: `p="primefaces"`, `h="jakarta.faces.html"`. Apply via `styleClass`
on PrimeFaces components or `class` on plain Facelets/HTML markup. See
`.opencode/skills/primeflex/CONVENTIONS.md`.

State prefixes (`hover:`, `focus:`, `active:`) are supported on color classes.
Responsive prefixes are not applicable to color utilities.

## Palette names

Thirteen color palettes are available, each with a 50–900 scale:

> `blue`, `green`, `yellow`, `cyan`, `pink`, `indigo`, `teal`, `orange`,
> `bluegray`, `purple`, `red`, `gray`, `primary`

## Text color

Pattern: `text-{color}-{50|100|200|300|400|500|600|700|800|900}`

### Special classes

| Class | Properties |
|---|---|
| text-primary | color: var(--primary-color); |
| text-white | color: #ffffff; |
| text-color | color: var(--text-color); |
| text-color-secondary | color: var(--text-color-secondary); |

### Surface scale

Pattern: `text-{0,50,100,200,300,400,500,600,700,800,900}` (maps to
`var(--surface-*)`).

### Alpha variants

| Class | Properties |
|---|---|
| text-white-alpha-{10..90} | color: rgba(255,255,255,0.1)..0.9; |
| text-black-alpha-{10..90} | color: rgba(0,0,0,0.1)..0.9; |

## Background color

Pattern: `bg-{color}-{50|100|200|300|400|500|600|700|800|900}`

### Special classes

| Class | Properties |
|---|---|
| bg-primary | background-color: var(--primary-color); color: var(--primary-color-text); |
| bg-primary-reverse | background-color: var(--primary-color-text); color: var(--primary-color); |
| bg-white | background-color: #ffffff; |

### Surface classes

| Class | Properties |
|---|---|
| surface-ground | background-color: var(--surface-ground); |
| surface-section | background-color: var(--surface-section); |
| surface-card | background-color: var(--surface-card); |
| surface-overlay | background-color: var(--surface-overlay); |
| surface-hover | background-color: var(--surface-hover); |
| surface-0 | background-color: var(--surface-0); |
| surface-{50,100,200,300,400,500,600,700,800,900} | background-color: var(--surface-*); |

### Alpha variants

| Class | Properties |
|---|---|
| bg-white-alpha-{10..90} | background-color: rgba(255,255,255,0.1)..0.9; |
| bg-black-alpha-{10..90} | background-color: rgba(0,0,0,0.1)..0.9; |

## Border color

Pattern: `border-{color}-{50|100|200|300|400|500|600|700|800|900}`

### Special classes

| Class | Properties |
|---|---|
| border-primary | border-color: var(--primary-color); |
| border-white | border-color: #ffffff; |
| border-transparent | border-color: transparent; |
| surface-border | border-color: var(--surface-border); |

### Surface scale

Pattern: `border-{0,50,200,300,400,500,600,700,800,900}` (maps to
`var(--surface-*)`).

> **Note:** The source doc lists `border-200` twice — first mapping to
> `var(--surface-100)` (likely a bug; the intended `border-100` class is
> absent). The second `border-200` maps to `var(--surface-200)`.

### Alpha variants

| Class | Properties |
|---|---|
| border-white-alpha-{10..90} | border-color: rgba(255,255,255,0.1)..0.9; |
| border-black-alpha-{10..90} | border-color: rgba(0,0,0,0.1)..0.9; |

## State prefixes

Color classes support `hover:`, `focus:`, and `active:` prefixes:

```xhtml
<div class="text-500 hover:text-700 surface-overlay border-round border-1 p-3">
    Hover me — text changes from surface-500 to surface-700
</div>
<div class="text-cyan-500 hover:text-cyan-700 surface-overlay border-round border-1 p-3">
    Hover me — text changes from cyan-500 to cyan-700
</div>
```

These apply to all color patterns: text, background, and border classes.

## Usage

Status tag with palette background and text:

```xhtml
<p:tag value="Approved" styleClass="bg-green-100 text-green-900 border-green-500 border-1"/>
```

Semantic surface panel:

```xhtml
<div class="surface-card border-round p-3 shadow-1">
    <h:outputText value="Card title" styleClass="text-xl font-bold text-color"/>
    <p class="text-color-secondary">Description text.</p>
</div>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/textcolor/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/textcolor/pseudostatesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/backgroundcolor/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/bordercolor/classesdoc.js`
