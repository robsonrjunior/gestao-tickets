---
name: primeflex-spacing
description: >-
  How to use PrimeFlex 3.3.1 margin and padding utility classes correctly.
  USE FOR: margin, padding, spacing utilities, auto margins, negative margins,
  responsive spacing, px/py/pt/pr/pb/pl, mx/my/mt/mr/mb/ml — controlling outer
  and inner spacing in JSF/Facelets via styleClass.
---

# PrimeFlex spacing utilities

Margin (`m-*`) and padding (`p-*`) classes. All support responsive prefixes
(`sm:`, `md:`, `lg:`, `xl:`). State variants (`hover:`, `focus:`, `active:`) do
not apply to spacing. Apply to PrimeFaces components via `styleClass`.

## Numeric scale

| Level | Value |
|---|---|
| 0 | 0 |
| 1 | 0.25rem |
| 2 | 0.5rem |
| 3 | 1rem |
| 4 | 1.5rem |
| 5 | 2rem |
| 6 | 3rem |
| 7 | 4rem |
| 8 | 5rem |

## Margin classes

### All sides & auto

| Class | Properties |
|---|---|
| `m-{0..8}` | `margin: {value};` |
| `m-auto` | `margin: auto;` |
| `mt-auto` | `margin-top: auto;` |
| `mb-auto` | `margin-bottom: auto;` |
| `ml-auto` | `margin-left: auto;` |
| `mr-auto` | `margin-right: auto;` |

### Single side

| Class | Properties |
|---|---|
| `mt-{0..8}` | `margin-top: {value};` |
| `mr-{0..8}` | `margin-right: {value};` |
| `mb-{0..8}` | `margin-bottom: {value};` |
| `ml-{0..8}` | `margin-left: {value};` |

### Axis

| Class | Properties |
|---|---|
| `mx-{0..8}` | `margin-left: {value}; margin-right: {value};` |
| `my-{0..8}` | `margin-top: {value}; margin-bottom: {value};` |
| `mx-auto` | `margin-left: auto; margin-right: auto;` |
| `my-auto` | `margin-top: auto; margin-bottom: auto;` |

## Negative margin classes

| Class | Properties |
|---|---|
| `-m-{1..8}` | `margin: -{value};` |
| `-mt-{1..8}` | `margin-top: -{value};` |
| `-mr-{1..8}` | `margin-right: -{value};` |
| `-mb-{1..8}` | `margin-bottom: -{value};` |
| `-ml-{1..8}` | `margin-left: -{value};` |
| `-mx-{1..8}` | `margin-left: -{value}; margin-right: -{value};` |
| `-my-{1..8}` | `margin-top: -{value}; margin-bottom: -{value};` |

## Padding classes

### All sides

| Class | Properties |
|---|---|
| `p-{0..8}` | `padding: {value};` |

### Single side

| Class | Properties |
|---|---|
| `pt-{0..8}` | `padding-top: {value};` |
| `pr-{0..8}` | `padding-right: {value};` |
| `pb-{0..8}` | `padding-bottom: {value};` |
| `pl-{0..8}` | `padding-left: {value};` |

### Axis

| Class | Properties |
|---|---|
| `px-{0..8}` | `padding-left: {value}; padding-right: {value};` |
| `py-{0..8}` | `padding-top: {value}; padding-bottom: {value};` |

## Example (XHTML/JSF)

```xhtml
<p:panel header="Card" styleClass="p-4 m-3">
    <p:commandButton value="Submit" styleClass="mt-3" />
</p:panel>

<div class="px-4 py-2 md:px-6 md:py-3">
    <h:outputText value="Responsive spacing with md: prefix" />
</div>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/margin/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/padding/`
