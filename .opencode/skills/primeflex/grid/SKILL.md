---
name: primeflex-grid
description: >-
  How to build PrimeFlex 3.3.1 12-column grids and form layouts in JSF
  Facelets views. USE FOR: grid system, 12-column grid, col-*, responsive
  columns (md:col-6 etc.), offsets (col-offset-*), gutters (grid-nogutter),
  nested grids, fixed-width columns (col-fixed), multiline wrapping, form
  layout, field, formgrid, field-checkbox, field-radiobutton, horizontal
  form, inline form, help text. Do NOT use for flexbox layout utilities
  (see primeflex-flexbox skill).
---

# PrimeFlex 3.3.1 — Grid system & form layout

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. Apply grid classes via `styleClass` on `p:`
components or `class` on plain `<div>`.

The FlexGrid is a CSS-flexbox-based 12-column layout system. The
container gets `grid`, each column gets `col` (auto-width) or
`col-{1..12}` (fixed fraction). Gutters are 0.5rem by default; use
`grid-nogutter` to remove them.

Responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`) are supported on all
grid and column classes. State variants are not supported on layout
utilities.

## Grid class reference

| Class | Properties |
|---|---|
| `grid` | `display: flex; flex-wrap: wrap; margin-right: -0.5rem; margin-left: -0.5rem; margin-top: -0.5rem` |
| `grid-nogutter` | `margin-right: 0; margin-left: 0; margin-top: 0` |
| `col` | `flex-grow: 1; flex-basis: 0; padding: $gutter` |
| `col-fixed` | `flex: 0 0 auto; padding: $gutter` |
| `col-1` | `flex: 0 0 auto; padding: $gutter; width: 8.3333%` |
| `col-2` | `flex: 0 0 auto; padding: $gutter; width: 16.6667%` |
| `col-3` | `flex: 0 0 auto; padding: $gutter; width: 25%` |
| `col-4` | `flex: 0 0 auto; padding: $gutter; width: 33.3333%` |
| `col-5` | `flex: 0 0 auto; padding: $gutter; width: 41.6667%` |
| `col-6` | `flex: 0 0 auto; padding: $gutter; width: 50%` |
| `col-7` | `flex: 0 0 auto; padding: $gutter; width: 58.3333%` |
| `col-8` | `flex: 0 0 auto; padding: $gutter; width: 66.6667%` |
| `col-9` | `flex: 0 0 auto; padding: $gutter; width: 75%` |
| `col-10` | `flex: 0 0 auto; padding: $gutter; width: 83.3333%` |
| `col-11` | `flex: 0 0 auto; padding: $gutter; width: 91.6667%` |
| `col-12` | `flex: 0 0 auto; padding: $gutter; width: 100%` |

### Offset classes

| Class | Properties |
|---|---|
| `col-offset-0` | `margin-left: 0` |
| `col-offset-1` | `margin-left: 8.3333%` |
| `col-offset-2` | `margin-left: 16.6667%` |
| `col-offset-3` | `margin-left: 25%` |
| `col-offset-4` | `margin-left: 33.3333%` |
| `col-offset-5` | `margin-left: 41.6667%` |
| `col-offset-6` | `margin-left: 50%` |
| `col-offset-7` | `margin-left: 58.3333%` |
| `col-offset-8` | `margin-left: 66.6667%` |
| `col-offset-9` | `margin-left: 75%` |
| `col-offset-10` | `margin-left: 83.3333%` |
| `col-offset-11` | `margin-left: 91.6667%` |
| `col-offset-12` | `margin-left: 100%` |

Offset classes apply `margin-left` to a column, avoiding empty spacer
columns. Col-* and offset values use the same 12-column fractions.

### Gutter classes

`grid-nogutter` removes gutters from the container (negative margins
set to 0). Apply `grid-nogutter` on individual `col` children to
remove padding on that column only.

## Responsive grid

Use breakpoint prefixes to change column widths per screen size.
Columns wrap when the total exceeds 12.

```xhtml
<div class="grid">
    <div class="col-12 md:col-6 lg:col-3">
        <p:outputLabel value="Full-width on phone, half on tablet, quarter on desktop"/>
    </div>
    <div class="col-12 md:col-6 lg:col-3">
        <p:outputLabel value="Column 2"/>
    </div>
    <div class="col-12 md:col-6 lg:col-3">
        <p:outputLabel value="Column 3"/>
    </div>
    <div class="col-12 md:col-6 lg:col-3">
        <p:outputLabel value="Column 4"/>
    </div>
</div>
```

Fixed-width columns let a column set an explicit width while siblings
fill the remaining space:

```xhtml
<div class="grid">
    <div class="col-fixed" style="width:100px">
        <i class="pi pi-search"/>
    </div>
    <div class="col">
        <p:inputText styleClass="w-full"/>
    </div>
</div>
```

## Nested grids

Place `grid` containers inside `col` children for complex layouts.
Counts reset for each nesting level.

```xhtml
<div class="grid">
    <div class="col-8">
        <div class="grid">
            <div class="col-6">6 of 8</div>
            <div class="col-6">6 of 8</div>
            <div class="col-12">12 of 8</div>
        </div>
    </div>
    <div class="col-4">4</div>
</div>
```

## Form layout

### Vertical form

Default stack. Each field wraps in `class="field"`.

```xhtml
<div class="field">
    <p:outputLabel for="firstname" value="Firstname"/>
    <p:inputText id="firstname" styleClass="w-full"/>
</div>
<div class="field">
    <p:outputLabel for="lastname" value="Lastname"/>
    <p:inputText id="lastname" styleClass="w-full"/>
</div>
```

### Vertical form with grid (`formgrid`)

`formgrid grid` groups fields horizontally in a 12-column grid with
tighter field margins.

```xhtml
<div class="formgrid grid">
    <div class="field col-12 md:col-6">
        <p:outputLabel for="firstname2" value="Firstname"/>
        <p:inputText id="firstname2" styleClass="w-full"/>
    </div>
    <div class="field col-12 md:col-6">
        <p:outputLabel for="lastname2" value="Lastname"/>
        <p:inputText id="lastname2" styleClass="w-full"/>
    </div>
    <div class="field col-12">
        <p:outputLabel for="address" value="Address"/>
        <p:inputTextarea id="address" rows="4" styleClass="w-full"/>
    </div>
    <div class="field col-12 md:col-6">
        <p:outputLabel for="city" value="City"/>
        <p:inputText id="city" styleClass="w-full"/>
    </div>
    <div class="field col-12 md:col-3">
        <p:outputLabel for="state" value="State"/>
        <p:selectOneMenu id="state" styleClass="w-full"/>
    </div>
    <div class="field col-12 md:col-3">
        <p:outputLabel for="zip" value="Zip"/>
        <p:inputText id="zip" styleClass="w-full"/>
    </div>
</div>
```

### Horizontal form

Combine `field` with `grid` to place labels beside inputs. Use
`col-fixed` for fixed-width labels or responsive column widths.

```xhtml
<div class="field grid">
    <p:outputLabel for="firstname4" value="Firstname"
        styleClass="col-12 mb-2 md:col-2 md:mb-0"/>
    <div class="col-12 md:col-10">
        <p:inputText id="firstname4" styleClass="w-full"/>
    </div>
</div>
<div class="field grid">
    <p:outputLabel for="lastname4" value="Lastname"
        styleClass="col-12 mb-2 md:col-2 md:mb-0"/>
    <div class="col-12 md:col-10">
        <p:inputText id="lastname4" styleClass="w-full"/>
    </div>
</div>
```

Fixed-width label variant:

```xhtml
<div class="field grid">
    <p:outputLabel for="firstname3" value="Firstname"
        class="col-fixed" style="width:100px"/>
    <div class="col">
        <p:inputText id="firstname3"/>
    </div>
</div>
```

### Inline form

Wrap fields and buttons in `formgroup-inline` for horizontal
side-by-side layout.

```xhtml
<div class="formgroup-inline">
    <div class="field">
        <p:inputText id="firstname5" placeholder="Firstname"/>
    </div>
    <div class="field">
        <p:inputText id="lastname5" placeholder="Lastname"/>
    </div>
    <p:commandButton value="Submit" styleClass="bg-primary"/>
</div>
```

### Checkbox & radio button fields

Vertical:

```xhtml
<div class="field-checkbox">
    <p:selectBooleanCheckbox id="city1"/>
    <p:outputLabel for="city1" value="Chicago"/>
</div>
<div class="field-radiobutton">
    <p:selectOneRadio id="city2"/>
    <p:outputLabel for="city2" value="Los Angeles"/>
</div>
```

Horizontal (wrap in `formgroup-inline`):

```xhtml
<div class="formgroup-inline">
    <div class="field-checkbox">
        <p:selectBooleanCheckbox id="city3"/>
        <p:outputLabel for="city3" value="Chicago"/>
    </div>
    <div class="field-radiobutton">
        <p:selectOneRadio id="city4"/>
        <p:outputLabel for="city4" value="Los Angeles"/>
    </div>
</div>
```

### Help text

Place a `<small>` element inside `field` for input descriptions.

```xhtml
<div class="field">
    <p:outputLabel for="username" value="Username"/>
    <p:inputText id="username" styleClass="w-full"/>
    <small id="username-help">Enter your username.</small>
</div>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/gridsystem/` — grid classes, 12-column, responsive, offsets, gutters, nested grids, fixed-width columns, multiline
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/formlayout/` — vertical, horizontal, inline, help text, advanced grid form, checkbox/radiobutton fields
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/gridsystem/classesdoc.js` — authoritative class-to-CSS-property table
