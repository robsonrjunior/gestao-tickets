---
name: primeflex-sizing
description: >-
  How to use PrimeFlex 3.3.1 width, height, min/max width, and min/max height
  utility classes correctly. USE FOR: w-full, w-screen, w-auto, w-min, w-max,
  w-{1..12} fractions, w-{1..30}rem, h-full, h-screen, h-auto, h-{1..30}rem,
  min-w-0, min-w-full, min-w-screen, min-w-min, min-w-max, min-h-0, min-h-full,
  min-h-screen, max-w-*, max-h-* — controlling element dimensions in
  JSF/Facelets via styleClass.
---

# PrimeFlex sizing utilities

Width, height, min-width, max-width, min-height, and max-height classes. All
support responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`). State variants do
not apply to sizing. Apply to PrimeFaces components via `styleClass`.

## Width classes

### Fluid & keyword

| Class | Properties |
|---|---|
| `w-full` | `width: 100%;` |
| `w-screen` | `width: 100vw;` |
| `w-auto` | `width: auto;` |
| `w-min` | `width: min-content;` |
| `w-max` | `width: max-content;` |

### 12-column fractions

| Class | Width |
|---|---|
| `w-1` | 8.3333% |
| `w-2` | 16.6667% |
| `w-3` | 25% |
| `w-4` | 33.3333% |
| `w-5` | 41.6667% |
| `w-6` | 50% |
| `w-7` | 58.3333% |
| `w-8` | 66.6667% |
| `w-9` | 75% |
| `w-10` | 83.3333% |
| `w-11` | 91.6667% |
| `w-12` | 100% |

### Rem-based fixed widths

`w-{1..30}rem` — sets `width: {N}rem;` (increments of 1rem).

## Height classes

### Fluid & keyword

| Class | Properties |
|---|---|
| `h-full` | `height: 100%;` |
| `h-screen` | `height: 100vh;` |
| `h-auto` | `height: auto;` |

### Rem-based fixed heights

`h-{1..30}rem` — sets `height: {N}rem;` (increments of 1rem).

## Min-width classes

| Class | Properties |
|---|---|
| `min-w-0` | `min-width: 0px;` |
| `min-w-full` | `min-width: 100%;` |
| `min-w-screen` | `min-width: 100vw;` |
| `min-w-min` | `min-width: min-content;` |
| `min-w-max` | `min-width: max-content;` |

## Max-width classes

| Class | Properties |
|---|---|
| `max-w-0` | `max-width: 0px;` |
| `max-w-full` | `max-width: 100%;` |
| `max-w-screen` | `max-width: 100vw;` |
| `max-w-min` | `max-width: min-content;` |
| `max-w-max` | `max-width: max-content;` |

Rem-based: `max-w-{1..30}rem` — sets `max-width: {N}rem;`.

## Min-height classes

| Class | Properties |
|---|---|
| `min-h-0` | `min-height: 0px;` |
| `min-h-full` | `min-height: 100%;` |
| `min-h-screen` | `min-height: 100vh;` |

## Max-height classes

| Class | Properties |
|---|---|
| `max-h-0` | `max-height: 0px;` |
| `max-h-full` | `max-height: 100%;` |
| `max-h-screen` | `max-height: 100vh;` |

Rem-based: `max-h-{1..30}rem` — sets `max-height: {N}rem;`.

## Example (XHTML/JSF)

```xhtml
<div class="w-full md:w-6 p-3">
    <p:panel header="Card" styleClass="w-full max-w-30rem h-20rem">
        <p:commandButton value="Action" styleClass="w-full" />
    </p:panel>
</div>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/width/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/height/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/minwidth/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/maxwidth/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/minheight/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/maxheight/`
