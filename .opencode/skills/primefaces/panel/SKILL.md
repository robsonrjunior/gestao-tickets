---
name: primefaces-panel
description: >-
  How to build PrimeFaces layout/panel components correctly, sourced from the
  vendored showcase. USE FOR: panel, panelGrid, accordionPanel, tabView,
  fieldset, card, outputPanel, scrollPanel, splitter, toolbar, divider,
  notificationBar, dashboard, wizard, grid/flexGrid — grouping and laying out
  content in JSF/Facelets.
---

# PrimeFaces panel components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. Most panels are markup-only containers; toggle/close
events can be wired via `p:ajax` to a bean (see
`.opencode/skills/primefaces/CONVENTIONS.md`).

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:panel` | Titled, optionally toggleable/closable container | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/panel.xhtml` |
| `p:panelGrid` | Table/grid layout of labeled fields | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/panelGrid.xhtml` |
| `p:accordionPanel` | Stacked collapsible sections | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/accordionPanel.xhtml` |
| `p:tabView` | Tabbed content panels | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/tabView.xhtml` |
| `p:fieldset` | Legend-titled toggleable group | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/fieldset.xhtml` |
| `p:card` | Card container (title/subtitle/footer) | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/card.xhtml` |
| `p:outputPanel` | Ajax-updatable wrapper | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/outputPanel.xhtml` |
| `p:scrollPanel` | Custom scrollbars | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/scrollPanel.xhtml` |
| `p:splitter` | Resizable split regions | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/splitter.xhtml` |
| `p:toolbar` | Left/right action bar | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/toolbar.xhtml` |
| `p:divider` | Horizontal/vertical separator | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/divider.xhtml` |
| `p:notificationBar` | Top/bottom sliding bar | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/notificationBar.xhtml` |
| `p:dashboard` | Draggable widget layout | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/dashboard.xhtml` |
| `p:wizard` | Multi-step flow | `primefaces/primefaces-showcase/src/main/webapp/ui/panel/wizard.xhtml` |

## Panel — canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/panel/panel.xhtml`
(bean `panelView` handles `close`/`toggle` events).

```xhtml
<p:panel header="Header" footer="Movie Details">
    <p class="m-0">Content...</p>
</p:panel>

<!-- Toggleable + closable, with ajax callbacks -->
<p:panel header="Header" toggleable="true" closable="true" widgetVar="panel">
    <p:ajax event="close" listener="#{panelView.onClose}" update="msgs"/>
    <p:ajax event="toggle" listener="#{panelView.onToggle}" update="msgs"/>
    <p class="m-0">Content...</p>
</p:panel>
```

## TabView

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/panel/tabView.xhtml`.

```xhtml
<p:tabView>
    <p:tab title="Header I">
        <p class="m-0">Content I</p>
    </p:tab>
    <p:tab title="Header II">
        <p class="m-0">Content II</p>
    </p:tab>
</p:tabView>
```

Dynamic/ajax tabs: `dynamic="true" cache="true"`; wire tab change with
`<p:ajax event="tabChange" listener="#{bean.onChange}"/>`.

## AccordionPanel

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/panel/accordionPanel.xhtml`.

```xhtml
<p:accordionPanel>
    <p:tab title="Section 1"><p class="m-0">...</p></p:tab>
    <p:tab title="Section 2"><p class="m-0">...</p></p:tab>
</p:accordionPanel>
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/panel/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/panel/`.
