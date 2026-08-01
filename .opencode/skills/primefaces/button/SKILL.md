---
name: primefaces-button
description: >-
  How to build PrimeFaces button/command components correctly, sourced from the
  vendored showcase. USE FOR: commandButton, button, commandLink, link,
  linkButton, splitButton, speedDial — actions, navigation links, severities,
  icons, and ajax command handling in JSF/Facelets.
---

# PrimeFaces button components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. `p:commandButton` submits/invokes actions (ajax by
default); `p:button`/`p:link` are navigation-only. Severity/style via
`ui-button-*` classes; icons via PrimeIcons (`pi pi-*`). See
`.opencode/skills/primefaces/CONVENTIONS.md`.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:commandButton` | Ajax/non-ajax action button | `primefaces/primefaces-showcase/src/main/webapp/ui/button/commandButton.xhtml` |
| `p:button` | Navigation button (GET, `outcome`) | `primefaces/primefaces-showcase/src/main/webapp/ui/button/button.xhtml` |
| `p:commandLink` | Ajax action link | `primefaces/primefaces-showcase/src/main/webapp/ui/button/commandLink.xhtml` |
| `p:link` | Navigation link (GET) | `primefaces/primefaces-showcase/src/main/webapp/ui/button/link.xhtml` |
| `p:linkButton` | Link styled as a button | `primefaces/primefaces-showcase/src/main/webapp/ui/button/linkButton.xhtml` |
| `p:splitButton` | Primary action + dropdown | `primefaces/primefaces-showcase/src/main/webapp/ui/button/splitButton.xhtml` |
| `p:speedDial` | Floating radial action menu | `primefaces/primefaces-showcase/src/main/webapp/ui/button/speedDial.xhtml` |

## commandButton — canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/button/commandButton.xhtml`.

```xhtml
<!-- Client-only button (no submit) -->
<p:commandButton type="button" value="Submit"/>

<!-- With icon and severity -->
<p:commandButton type="button" value="Success" icon="pi pi-check" styleClass="ui-button-success"/>

<!-- Ajax action invoking a bean and updating a target -->
<p:commandButton value="Save" action="#{bean.save}" update="msgs" icon="pi pi-check"/>
```

Severity classes: `ui-button-secondary`, `ui-button-success`, `ui-button-info`,
`ui-button-warning`, `ui-button-help`, `ui-button-danger`. Style modifiers:
`ui-button-raised`, `ui-button-rounded`, `ui-button-outlined`, `ui-button-flat`.

## Navigation button/link

```xhtml
<p:button value="Go" outcome="/ui/home" icon="pi pi-home"/>
<p:link value="PrimeFaces" href="https://www.primefaces.org"/>
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/button/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/button/`.
