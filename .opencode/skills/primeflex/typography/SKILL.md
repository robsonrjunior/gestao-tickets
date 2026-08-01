---
name: primeflex-typography
description: >-
  How to build PrimeFlex 3.3.1 typography utilities correctly, sourced from the
  vendored docs. USE FOR: font size, font style, font weight, line height,
  text align, text decoration, text overflow, text transform, white space,
  vertical align, list style type — applying type-scale, alignment, and
  list-style classes in JSF/Facelets views.
---

# PrimeFlex typography utilities

PrimeFlex 3.3.1 CSS utility classes for typography in JSF/Facelets views.
Namespaces: `p="primefaces"`, `h="jakarta.faces.html"`. Apply via `styleClass`
on PrimeFaces components or `class` on plain Facelets/HTML markup. See
`.opencode/skills/primeflex/CONVENTIONS.md`.

Responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`) are supported by text-align
classes. State prefixes (`hover:`, `focus:`, `active:`) are not supported by
typography classes.

## Font size

| Class | Properties |
|---|---|
| text-xs | font-size: .75rem; |
| text-sm | font-size: .875rem; |
| text-base | font-size: 1rem; |
| text-lg | font-size: 1.125rem; |
| text-xl | font-size: 1.25rem; |
| text-2xl | font-size: 1.5rem; |
| text-3xl | font-size: 1.75rem; |
| text-4xl | font-size: 2rem; |
| text-5xl | font-size: 2.5rem; |
| text-6xl | font-size: 3rem; |
| text-7xl | font-size: 4rem; |
| text-8xl | font-size: 6rem; |

## Font style

| Class | Properties |
|---|---|
| font-italic | font-style: italic; |

## Font weight

| Class | Properties |
|---|---|
| font-light | font-weight: 300; |
| font-normal | font-weight: 400; |
| font-medium | font-weight: 500; |
| font-semibold | font-weight: 600; |
| font-bold | font-weight: 700; |

## Line height

| Class | Properties |
|---|---|
| line-height-1 | line-height: 1; |
| line-height-2 | line-height: 1.25; |
| line-height-3 | line-height: 1.5; |
| line-height-4 | line-height: 2; |

## Text align

| Class | Properties |
|---|---|
| text-left | text-align: left; |
| text-center | text-align: center; |
| text-right | text-align: right; |
| text-justify | text-align: justify; |

Responsive variants supported: `sm:text-left`, `sm:text-center`,
`sm:text-right`, `sm:text-justify` (and `md:`, `lg:`, `xl:` equivalents).

## Text decoration

| Class | Properties |
|---|---|
| underline | text-decoration: underline; |
| line-through | text-decoration: line-through; |
| no-underline | text-decoration: none; |

## Text overflow

| Class | Properties |
|---|---|
| text-overflow-clip | text-overflow: clip; |
| text-overflow-ellipsis | text-overflow: ellipsis; |

## Text transform

| Class | Properties |
|---|---|
| lowercase | text-transform: lowercase; |
| uppercase | text-transform: uppercase; |
| capitalize | text-transform: capitalize; |

## White space

| Class | Properties |
|---|---|
| white-space-normal | white-space: normal; |
| white-space-nowrap | white-space: nowrap; |

## Vertical align

| Class | Properties |
|---|---|
| vertical-align-baseline | vertical-align: baseline; |
| vertical-align-top | vertical-align: top; |
| vertical-align-middle | vertical-align: middle; |
| vertical-align-bottom | vertical-align: bottom; |
| vertical-align-text-top | vertical-align: text-top; |
| vertical-align-text-bottom | vertical-align: text-bottom; |
| vertical-align-sub | vertical-align: sub; |
| vertical-align-super | vertical-align: super; |

## List style type

| Class | Properties |
|---|---|
| list-none | list-style: none; |
| list-disc | list-style: disc; |
| list-decimal | list-style: decimal; |

## Usage

Heading with responsive alignment:

```xhtml
<h:outputText value="Welcome" styleClass="text-2xl font-bold md:text-left text-center"/>
```

Label with font style and size:

```xhtml
<p:outputLabel value="Price" styleClass="text-sm font-italic text-color-secondary"/>
```

List with custom style:

```xhtml
<ul class="list-none">
  <li class="text-base font-medium line-height-3">Item one</li>
  <li class="text-base font-medium line-height-3">Item two</li>
</ul>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/fontsize/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/fontstyle/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/fontweight/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/lineheight/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/textalign/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/textdecoration/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/textoverflow/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/texttransform/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/whitespace/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/verticalalign/classesdoc.js`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/liststyletype/classesdoc.js`
