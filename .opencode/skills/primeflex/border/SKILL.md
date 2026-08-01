---
name: primeflex-border
description: >-
  How to build borders with PrimeFlex 3.3.1 CSS utility classes. USE FOR:
  border radius, rounded corners, circles, per-side rounding,
  border-style (solid/dashed/dotted/double), border-width (0–3px plus
  per-side widths like border-top/border-x/border-y), outline-none —
  border-radius, border-style, border-width, and outline in JSF/Facelets.
---

# PrimeFlex border utilities

Border utilities control border-radius, border-style, border-width, and
outline. Apply via `styleClass` on `p:` components or `class` on plain
markup. See `.opencode/skills/primeflex/CONVENTIONS.md`.

Responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`) are supported. State
prefixes are not supported for border utilities.

## Border radius

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/borderradius/classesdoc.js`.

| Class | Properties |
|---|---|
| `border-noround` | `border-radius: 0;` |
| `border-round` | `border-radius: var(--border-radius);` |
| `border-round-xs` | `border-radius: 0.125rem;` |
| `border-round-sm` | `border-radius: 0.25rem;` |
| `border-round-md` | `border-radius: 0.375rem;` |
| `border-round-lg` | `border-radius: 0.5rem;` |
| `border-round-xl` | `border-radius: 0.75rem;` |
| `border-round-2xl` | `border-radius: 1rem;` |
| `border-round-3xl` | `border-radius: 1.5rem;` |
| `border-circle` | `border-radius: 50%;` |

### Per-side "no round"

| Class | Properties |
|---|---|
| `border-noround-left` | `border-top-left-radius: 0; border-bottom-left-radius: 0;` |
| `border-noround-top` | `border-top-left-radius: 0; border-top-right-radius: 0;` |
| `border-noround-right` | `border-top-right-radius: 0; border-bottom-right-radius: 0;` |
| `border-noround-bottom` | `border-bottom-left-radius: 0; border-bottom-right-radius: 0;` |

### Per-side round (var scale)

| Class | Properties |
|---|---|
| `border-round-left` | `border-top-left-radius: var(--border-radius); border-bottom-left-radius: var(--border-radius);` |
| `border-round-top` | `border-top-left-radius: var(--border-radius); border-top-right-radius: var(--border-radius);` |
| `border-round-right` | `border-top-right-radius: var(--border-radius); border-bottom-right-radius: var(--border-radius);` |
| `border-round-bottom` | `border-bottom-left-radius: var(--border-radius); border-bottom-right-radius: var(--border-radius);` |

### Per-side + size (pattern: `border-round-{side}-{size}`)

Sides: `left`, `top`, `right`, `bottom`.
Sizes: `xs` (0.125rem), `sm` (0.25rem), `md` (0.375rem), `lg` (0.5rem),
`xl` (0.75rem), `2xl` (1rem), `3xl` (1.5rem).

### Per-side circle

| Class | Properties |
|---|---|
| `border-circle-left` | `border-top-left-radius: 50%; border-bottom-left-radius: 50%;` |
| `border-circle-top` | `border-top-left-radius: 50%; border-top-right-radius: 50%;` |
| `border-circle-right` | `border-top-right-radius: 50%; border-bottom-right-radius: 50%;` |
| `border-circle-bottom` | `border-bottom-left-radius: 50%; border-bottom-right-radius: 50%;` |

## Border style

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/borderstyle/classesdoc.js`.

| Class | Properties |
|---|---|
| `border-solid` | `border-style: solid;` |
| `border-dashed` | `border-style: dashed;` |
| `border-dotted` | `border-style: dotted;` |
| `border-double` | `border-style: double;` |

## Border width

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/borderwidth/classesdoc.js`.

### All sides

| Class | Properties |
|---|---|
| `border-none` | `border-width: 0px;` |
| `border-1` | `border-width: 1px;` |
| `border-2` | `border-width: 2px;` |
| `border-3` | `border-width: 3px;` |

### Horizontal / vertical (x / y axes)

`border-x-{none,1,2,3}` (right + left)
`border-y-{none,1,2,3}` (top + bottom)

### Per-side

`border-{side}-{none,1,2,3}` where side is `top`, `left`, `bottom`, or `right`.

## Outline

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/outline/classesdoc.js`.

| Class | Properties |
|---|---|
| `outline-none` | `outline: none;` |

## XHTML snippet

```xhtml
<div class="border-round-xl border-1 border-solid shadow-2 p-3">
  <span class="border-circle bg-primary text-white p-2 inline-flex align-items-center justify-content-center"
        style="width: 2.5rem; height: 2.5rem;">A</span>
  <span class="ml-2 font-bold">Avatar with circle border</span>
</div>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/borderradius/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/borderstyle/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/borderwidth/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/outline/`
