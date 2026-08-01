---
name: primefaces-input
description: >-
  How to build PrimeFaces input/form components correctly, sourced from the
  vendored showcase. USE FOR: inputText, inputTextarea, inputNumber, inputMask,
  password, autoComplete, selectOneMenu, selectManyMenu, selectOneRadio,
  selectBooleanCheckbox, selectManyCheckbox, listbox, cascadeSelect, chips,
  datePicker/calendar, colorPicker, slider, spinner, rating, knob, toggleSwitch,
  textEditor, signature, inputGroup, floatLabel, form layout — capturing user
  input in JSF/Facelets.
---

# PrimeFaces input components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. Inputs bind to bean properties via `value`; option
lists use `f:selectItem`/`f:selectItems`. See
`.opencode/skills/primefaces/CONVENTIONS.md` for the bean pattern.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:inputText` | Single-line text | `primefaces/primefaces-showcase/src/main/webapp/ui/input/inputText.xhtml` |
| `p:inputTextarea` | Multi-line text, autoResize, counter | `primefaces/primefaces-showcase/src/main/webapp/ui/input/inputTextarea.xhtml` |
| `p:inputNumber` | Formatted numeric input | `primefaces/primefaces-showcase/src/main/webapp/ui/input/inputNumber.xhtml` |
| `p:inputMask` | Masked input | `primefaces/primefaces-showcase/src/main/webapp/ui/input/inputMask.xhtml` |
| `p:password` | Password with strength/feedback | `primefaces/primefaces-showcase/src/main/webapp/ui/input/password.xhtml` |
| `p:autoComplete` | Suggestion-driven text/object input | `primefaces/primefaces-showcase/src/main/webapp/ui/input/autoComplete.xhtml` |
| `p:selectOneMenu` | Single-select dropdown | `primefaces/primefaces-showcase/src/main/webapp/ui/input/oneMenu.xhtml` |
| `p:selectOneRadio` | Radio group | `primefaces/primefaces-showcase/src/main/webapp/ui/input/oneRadio.xhtml` |
| `p:selectBooleanCheckbox` | Single checkbox | `primefaces/primefaces-showcase/src/main/webapp/ui/input/booleanCheckbox.xhtml` |
| `p:selectManyCheckbox` | Multi checkbox group | `primefaces/primefaces-showcase/src/main/webapp/ui/input/manyCheckbox.xhtml` |
| `p:selectManyMenu` / `p:listbox` | Multi/list selection | `primefaces/primefaces-showcase/src/main/webapp/ui/input/listbox.xhtml` |
| `p:cascadeSelect` | Hierarchical single-select | `primefaces/primefaces-showcase/src/main/webapp/ui/input/cascadeSelect.xhtml` |
| `p:chips` | Token/tag entry | `primefaces/primefaces-showcase/src/main/webapp/ui/input/chips.xhtml` |
| `p:datePicker` | Date/time/range picker | `primefaces/primefaces-showcase/src/main/webapp/ui/input/datepicker/` |
| `p:colorPicker` | Color selection | `primefaces/primefaces-showcase/src/main/webapp/ui/input/colorpicker/` |
| `p:slider` | Range slider | `primefaces/primefaces-showcase/src/main/webapp/ui/input/slider.xhtml` |
| `p:spinner` | Numeric stepper | `primefaces/primefaces-showcase/src/main/webapp/ui/input/spinner.xhtml` |
| `p:rating` | Star rating | `primefaces/primefaces-showcase/src/main/webapp/ui/input/rating.xhtml` |
| `p:knob` | Circular value dial | `primefaces/primefaces-showcase/src/main/webapp/ui/input/knob.xhtml` |
| `p:toggleSwitch` | On/off switch | `primefaces/primefaces-showcase/src/main/webapp/ui/input/toggleSwitch.xhtml` |
| `p:textEditor` | Rich-text (Quill) editor | `primefaces/primefaces-showcase/src/main/webapp/ui/input/textEditor.xhtml` |
| `p:signature` | Signature capture | `primefaces/primefaces-showcase/src/main/webapp/ui/input/signature.xhtml` |

## inputText — canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/input/inputText.xhtml`.

```xhtml
<p:outputLabel for="username" value="Username"/>
<p:inputText id="username" value="#{inputTextView.text}"/>

<!-- With icon -->
<span class="ui-input-icon-left">
    <i class="pi pi-search"/>
    <p:inputText placeholder="Search"/>
</span>
```

## selectOneMenu — dropdown with options

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/input/oneMenu.xhtml`
(bean `selectOneMenuView`).

```xhtml
<p:selectOneMenu id="option" value="#{selectOneMenuView.selectedOption}">
    <f:selectItem itemLabel="Select One" itemValue=""/>
    <f:selectItems value="#{selectOneMenuView.cities}"/>
</p:selectOneMenu>
```

## autoComplete — server-driven suggestions

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/input/autoComplete.xhtml`
(bean `autoCompleteView`). Provide a `completeMethod` returning suggestions.

```xhtml
<p:autoComplete value="#{autoCompleteView.txt1}"
                completeMethod="#{autoCompleteView.completeText}"
                minQueryLength="3" queryDelay="300" scrollHeight="250"/>
```

```java
public List<String> completeText(String query) {
    // filter and return matching suggestions for `query`
}
```

## Form layout

Showcase forms use PrimeFlex grid classes (`ui-fluid formgrid grid`,
`field col-12 md:col-4`) with `p:outputLabel for="@next"`. See
`primefaces/primefaces-showcase/src/main/webapp/ui/input/formLayout.xhtml` and
`primefaces/primefaces-showcase/src/main/webapp/ui/input/inputGroup.xhtml`.

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/input/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/input/`.
