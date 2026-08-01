---
name: primeflex-position
description: >-
  PrimeFlex 3.3.1 display and positioning utilities for JSF/Facelets. USE FOR:
  display (hidden, block, inline, inline-block, flex, inline-flex), positioning
  (static, fixed, relative, absolute, sticky), top/right/bottom/left offsets,
  z-index, overflow — show/hide, layering, and scroll control.
---

# PrimeFlex 3.3.1 — Position

PrimeFlex display, positioning, offset, z-index, and overflow utilities. All
classes support responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`). Apply to
PrimeFaces components via `styleClass`, to plain markup via `class`. See
`.opencode/skills/primeflex/CONVENTIONS.md`.

## display

| Class | Properties |
|---|---|
| `hidden` | `display: none` |
| `block` | `display: block` |
| `inline` | `display: inline` |
| `inline-block` | `display: inline-block` |
| `flex` | `display: flex` |
| `inline-flex` | `display: inline-flex` |

Responsive show/hide pattern: `hidden` hides at all sizes; prefix overrides it
at a breakpoint with the desired display value. Mobile-first: `md:block` means
"display block from md upwards."

## position

| Class | Properties |
|---|---|
| `static` | `position: static` |
| `fixed` | `position: fixed` |
| `relative` | `position: relative` |
| `absolute` | `position: absolute` |
| `sticky` | `position: sticky` |

## top / right / bottom / left offsets

`{direction}-{value}` where value is `auto`, `0`, `50` (50%), or `100` (100%).

| Class | Properties | Class | Properties |
|---|---|---|---|
| `top-auto` | `top: auto` | `bottom-auto` | `bottom: auto` |
| `top-0` | `top: 0` | `bottom-0` | `bottom: 0` |
| `top-50` | `top: 50%` | `bottom-50` | `bottom: 50%` |
| `top-100` | `top: 100%` | `bottom-100` | `bottom: 100%` |
| `right-auto` | `right: auto` | `left-auto` | `left: auto` |
| `right-0` | `right: 0` | `left-0` | `left: 0` |
| `right-50` | `right: 50%` | `left-50` | `left: 50%` |
| `right-100` | `right: 100%` | `left-100` | `left: 100%` |

## z-index

`z-{value}` where value is `auto`, `0`, `1`, `2`, `3`, `4`, `5`.

| Class | Properties |
|---|---|
| `z-auto` | `z-index: auto` |
| `z-0` | `z-index: 0` |
| `z-1` | `z-index: 1` |
| `z-2` | `z-index: 2` |
| `z-3` | `z-index: 3` |
| `z-4` | `z-index: 4` |
| `z-5` | `z-index: 5` |

## overflow

Two-axis: `overflow-{auto|hidden|visible|scroll}`.  
X-axis only: `overflow-x-{auto|hidden|visible|scroll}`.  
Y-axis only: `overflow-y-{auto|hidden|visible|scroll}`.

| Class | Properties |
|---|---|
| `overflow-auto` | `overflow: auto` |
| `overflow-hidden` | `overflow: hidden` |
| `overflow-visible` | `overflow: visible` |
| `overflow-scroll` | `overflow: scroll` |
| `overflow-x-auto` | `overflow-x: auto` |
| `overflow-x-hidden` | `overflow-x: hidden` |
| `overflow-x-visible` | `overflow-x: visible` |
| `overflow-x-scroll` | `overflow-x: scroll` |
| `overflow-y-auto` | `overflow-y: auto` |
| `overflow-y-hidden` | `overflow-y: hidden` |
| `overflow-y-visible` | `overflow-y: visible` |
| `overflow-y-scroll` | `overflow-y: scroll` |

## XHTML snippets

Responsive visibility: show an element from md upward, hide on smaller screens:

```xhtml
<div class="hidden md:block p-3 border-round bg-primary">
  Visible on tablet/desktop only
</div>
```

Badge positioning on a `p:commandButton` using relative parent + absolute child:

```xhtml
<div class="relative inline-flex">
  <p:commandButton value="Messages" icon="pi pi-envelope" type="button"/>
  <span class="absolute top-0 right-0 bg-red-500 text-white border-circle"
        style="width:1.25rem;height:1.25rem;text-align:center;line-height:1.25rem;">
    3
  </span>
</div>
```

## Source

| Topic | Path |
|---|---|
| display | `primeflex-3.3.1/primeflex-3.3.1/components/doc/display/` |
| position | `primeflex-3.3.1/primeflex-3.3.1/components/doc/position/` |
| toprightbottomleft | `primeflex-3.3.1/primeflex-3.3.1/components/doc/toprightbottomleft/` |
| zindex | `primeflex-3.3.1/primeflex-3.3.1/components/doc/zindex/` |
| overflow | `primeflex-3.3.1/primeflex-3.3.1/components/doc/overflow/` |
