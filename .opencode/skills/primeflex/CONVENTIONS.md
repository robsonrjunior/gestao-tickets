# PrimeFlex Skills — Authoring Conventions

Shared conventions for every skill under `.opencode/skills/primeflex/<family>/`.
These skills teach how to use PrimeFlex 3.3.1 CSS utility classes correctly in
Jakarta EE (Faces 4, PrimeFaces views) applications.

## Source of truth

All class tables and patterns are distilled from the vendored PrimeFlex docs:

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/<topic>/**`

Each topic directory contains React doc components; the authoritative class →
CSS-property tables live in `classesdoc.js` (JSX `doc-table` markup) and usage
examples live in the other `*doc.js` files. PrimeFlex version: **3.3.1**.
Treat everything under `primeflex-3.3.1/` as read-only. Do not copy any
license text; link to source directories instead.

## Topic → family map

Every topic directory maps to exactly one family skill (69 topics, 12 families):

| Skill family | Doc topics |
|---|---|
| setup | installation, theming, common |
| grid | gridsystem, formlayout |
| flexbox | flex, flexdirection, flexwrap, flexgrow, flexshrink, alignitems, aligncontent, alignself, justifycontent, order, gap |
| position | display, position, toprightbottomleft, zindex, overflow |
| spacing | margin, padding |
| sizing | width, height, minwidth, maxwidth, minheight, maxheight |
| typography | fontsize, fontstyle, fontweight, lineheight, textalign, textdecoration, textoverflow, texttransform, whitespace, verticalalign, liststyletype |
| colors | textcolor, backgroundcolor, bordercolor |
| border | borderradius, borderstyle, borderwidth, outline |
| background | backgroundposition, backgroundrepeat, backgroundsize |
| effects | opacity, elevation, cursor, userselect, pointerevents, appearance |
| motion | animations, animationdelay, animationduration, animationfill, animationiteration, animationtimingfunction, transitiondelay, transitionduration, transitionproperty, transitiontimingfunction, transformorigin, rotate, translate |

(Topic paths are relative to `primeflex-3.3.1/primeflex-3.3.1/components/doc/`.)

## SKILL.md structure

Each family skill MUST have:

1. **YAML frontmatter** with:
   - `name`: `primeflex-<family>`
   - `description`: one paragraph that says WHEN to use it and lists the
     utility topics covered ("USE FOR: ...").
2. **Body sections**:
   - Short intro (what the family covers + whether responsive/state prefixes
     apply; the prefix system itself is documented once in the `setup` skill).
   - Class reference tables: class name → CSS property, per topic.
   - 1–3 canonical snippets in the app's JSF context (`styleClass` on `p:`
     components or `class` on plain Facelets markup).
   - "Source" links to the repo-relative doc topic directories.

## Class table rules

- Class names MUST match the vendored 3.3.1 `classesdoc.js` sources exactly.
- Regular value scales MAY be condensed with pattern notation, e.g.
  `p-{0..8}`, provided the scale values are enumerated once nearby.
- Irregular sets (font sizes, shadows, border-radius, etc.) MUST be listed
  explicitly.
- Color palettes use pattern notation (`text-{color}-{50..900}`) plus the
  palette name list; do not enumerate all ~280 color classes.

## Responsive & state prefixes

- Breakpoints: `sm:` ≥576px, `md:` ≥768px, `lg:` ≥992px, `xl:` ≥1200px
  (min-width media queries, mobile-first).
- State variants: `hover:`, `focus:`, `active:` (supported by color and
  style utilities, not layout utilities).
- Each family skill states whether its classes support these prefixes and
  shows at least one prefixed example when supported.

## App usage conventions

- Apply classes to PrimeFaces components via `styleClass`, to plain markup via
  `class`.
- Prefer PrimeFlex utilities for layout/spacing tweaks in XHTML views; keep
  component behavior in PrimeFaces (`p:`) components.
