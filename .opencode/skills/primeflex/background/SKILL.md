---
name: primeflex-background
description: >-
  How to use PrimeFlex 3.3.1 background-position, background-repeat, and
  background-size utility classes correctly. USE FOR: bg-bottom, bg-center,
  bg-left, bg-right, bg-top, bg-left-bottom, bg-left-top, bg-right-bottom,
  bg-right-top, bg-repeat, bg-no-repeat, bg-repeat-x, bg-repeat-y,
  bg-repeat-round, bg-repeat-space, bg-auto, bg-cover, bg-contain — controlling
  background image placement and behavior in JSF/Facelets via styleClass.
---

# PrimeFlex background utilities

Background-position, background-repeat, and background-size classes. All support
responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`). State variants do not apply
to background utilities. Apply to PrimeFaces components via `styleClass`.

## Background position classes

| Class | Properties |
|---|---|
| `bg-bottom` | `background-position: bottom;` |
| `bg-center` | `background-position: center;` |
| `bg-left` | `background-position: left;` |
| `bg-left-bottom` | `background-position: left bottom;` |
| `bg-left-top` | `background-position: left top;` |
| `bg-right` | `background-position: right;` |
| `bg-right-top` | `background-position: right top;` |
| `bg-right-bottom` | `background-position: right bottom;` |
| `bg-top` | `background-position: top;` |

## Background repeat classes

| Class | Properties |
|---|---|
| `bg-repeat` | `background-repeat: repeat;` |
| `bg-no-repeat` | `background-repeat: no-repeat;` |
| `bg-repeat-x` | `background-repeat: repeat-x;` |
| `bg-repeat-y` | `background-repeat: repeat-y;` |
| `bg-repeat-round` | `background-repeat: round;` |
| `bg-repeat-space` | `background-repeat: space;` |

## Background size classes

| Class | Properties |
|---|---|
| `bg-auto` | `background-size: auto;` |
| `bg-cover` | `background-size: cover;` |
| `bg-contain` | `background-size: contain;` |

## Example (XHTML/JSF)

```xhtml
<div class="bg-no-repeat bg-center bg-cover w-full h-20rem"
     style="background-image: url('#{resource['images/banner.jpg']}');">
    <h:outputText value="Hero banner" styleClass="text-white" />
</div>

<!-- Responsive: different position on desktop -->
<div class="bg-left-top md:bg-center bg-no-repeat"
     style="background-image: url('icon.svg'); background-size: 5rem;"
     class="w-10rem h-10rem" />
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/backgroundposition/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/backgroundrepeat/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/backgroundsize/`
