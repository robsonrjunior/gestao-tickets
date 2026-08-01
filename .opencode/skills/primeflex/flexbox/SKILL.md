---
name: primeflex-flexbox
description: >-
  PrimeFlex 3.3.1 flexbox layout utilities for JSF/Facelets. USE FOR: flex,
  flex-direction, flex-wrap, flex-grow, flex-shrink, align-items, align-content,
  align-self, justify-content, order, gap, row-gap, column-gap — flexbox layout.
---

# PrimeFlex 3.3.1 — Flexbox

PrimeFlex flexbox utilities for laying out Flex containers and items. All classes
in this family support responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`). Apply
to PrimeFaces components via `styleClass`, to plain markup via `class`. See
`.opencode/skills/primeflex/CONVENTIONS.md`.

## flex — shorthand

| Class | Properties |
|---|---|
| `flex-1` | `flex: 1 1 0%` |
| `flex-auto` | `flex: 1 1 auto` |
| `flex-initial` | `flex: 0 1 auto` |
| `flex-none` | `flex: none` |

## flex-direction

| Class | Properties |
|---|---|
| `flex-row` | `flex-direction: row` |
| `flex-row-reverse` | `flex-direction: row-reverse` |
| `flex-column` | `flex-direction: column` |
| `flex-column-reverse` | `flex-direction: column-reverse` |

## flex-wrap

| Class | Properties |
|---|---|
| `flex-wrap` | `flex-wrap: wrap` |
| `flex-wrap-reverse` | `flex-wrap: wrap-reverse` |
| `flex-nowrap` | `flex-wrap: nowrap` |

## flex-grow

| Class | Properties |
|---|---|
| `flex-grow-0` | `flex-grow: 0` |
| `flex-grow-1` | `flex-grow: 1` |

## flex-shrink

| Class | Properties |
|---|---|
| `flex-shrink-0` | `flex-shrink: 0` |
| `flex-shrink-1` | `flex-shrink: 1` |

## align-items (container)

| Class | Properties |
|---|---|
| `align-items-stretch` | `align-items: stretch` |
| `align-items-start` | `align-items: flex-start` |
| `align-items-center` | `align-items: center` |
| `align-items-end` | `align-items: flex-end` |
| `align-items-baseline` | `align-items: baseline` |

## align-content (container, multi-line)

| Class | Properties |
|---|---|
| `align-content-start` | `align-content: flex-start` |
| `align-content-end` | `align-content: flex-end` |
| `align-content-center` | `align-content: center` |
| `align-content-between` | `align-content: space-between` |
| `align-content-around` | `align-content: space-around` |
| `align-content-evenly` | `align-content: space-evenly` |

## align-self (item)

| Class | Properties |
|---|---|
| `align-self-auto` | `align-self: auto` |
| `align-self-start` | `align-self: flex-start` |
| `align-self-end` | `align-self: flex-end` |
| `align-self-center` | `align-self: center` |
| `align-self-baseline` | `align-self: baseline` |
| `align-self-stretch` | `align-self: stretch` |

## justify-content (container)

| Class | Properties |
|---|---|
| `justify-content-start` | `justify-content: flex-start` |
| `justify-content-end` | `justify-content: flex-end` |
| `justify-content-center` | `justify-content: center` |
| `justify-content-between` | `justify-content: space-between` |
| `justify-content-around` | `justify-content: space-around` |
| `justify-content-evenly` | `justify-content: space-evenly` |

## order

`flex-order-{0..6}` — value is the integer order.

| Class | Properties |
|---|---|
| `flex-order-0` | `order: 0` |
| `flex-order-1` | `order: 1` |
| `flex-order-2` | `order: 2` |
| `flex-order-3` | `order: 3` |
| `flex-order-4` | `order: 4` |
| `flex-order-5` | `order: 5` |
| `flex-order-6` | `order: 6` |

## gap, row-gap, column-gap

Scale: `{0..8}` where `0` = `0`, `1` = `0.25rem`, `2` = `0.5rem`,
`3` = `1rem`, `4` = `1.5rem`, `5` = `2rem`, `6` = `3rem`, `7` = `4rem`,
`8` = `5rem`.

### gap

`gap-{0..8}` — sets both row and column gap.

| Class | Properties |
|---|---|
| `gap-0` | `gap: 0` |
| `gap-1` | `gap: 0.25rem` |
| `gap-2` | `gap: 0.5rem` |
| `gap-3` | `gap: 1rem` |
| `gap-4` | `gap: 1.5rem` |
| `gap-5` | `gap: 2rem` |
| `gap-6` | `gap: 3rem` |
| `gap-7` | `gap: 4rem` |
| `gap-8` | `gap: 5rem` |

### row-gap

`row-gap-{0..8}` — same scale.

### column-gap

`column-gap-{0..8}` — same scale.

## XHTML snippets

Toolbar with `p:commandButton` items and gap:

```xhtml
<div class="flex align-items-center justify-content-between gap-2">
  <p:commandButton value="Save" icon="pi pi-check" styleClass="ui-button-success"/>
  <p:commandButton value="Cancel" icon="pi pi-times" styleClass="ui-button-secondary"/>
</div>
```

Responsive direction: stacked on mobile, row on medium+:

```xhtml
<div class="flex flex-column md:flex-row gap-3">
  <p:panel header="Left" styleClass="flex-1"/>
  <p:panel header="Right" styleClass="flex-1"/>
</div>
```

## Source

| Topic | Path |
|---|---|
| flex | `primeflex-3.3.1/primeflex-3.3.1/components/doc/flex/` |
| flexdirection | `primeflex-3.3.1/primeflex-3.3.1/components/doc/flexdirection/` |
| flexwrap | `primeflex-3.3.1/primeflex-3.3.1/components/doc/flexwrap/` |
| flexgrow | `primeflex-3.3.1/primeflex-3.3.1/components/doc/flexgrow/` |
| flexshrink | `primeflex-3.3.1/primeflex-3.3.1/components/doc/flexshrink/` |
| alignitems | `primeflex-3.3.1/primeflex-3.3.1/components/doc/alignitems/` |
| aligncontent | `primeflex-3.3.1/primeflex-3.3.1/components/doc/aligncontent/` |
| alignself | `primeflex-3.3.1/primeflex-3.3.1/components/doc/alignself/` |
| justifycontent | `primeflex-3.3.1/primeflex-3.3.1/components/doc/justifycontent/` |
| order | `primeflex-3.3.1/primeflex-3.3.1/components/doc/order/` |
| gap | `primeflex-3.3.1/primeflex-3.3.1/components/doc/gap/` |
