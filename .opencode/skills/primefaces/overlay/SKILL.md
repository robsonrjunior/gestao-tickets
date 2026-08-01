---
name: primefaces-overlay
description: >-
  How to build PrimeFaces overlay components correctly, sourced from the vendored
  showcase. USE FOR: dialog, dynamic dialog, confirmDialog, confirmPopup,
  overlayPanel, sidebar, tooltip — modal/popup/overlay UI in JSF/Facelets.
---

# PrimeFaces overlay components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. Overlays are toggled client-side via their
`widgetVar` (`PF('name').show()`), or globally through `p:confirm`. See
`.opencode/skills/primefaces/CONVENTIONS.md`.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:dialog` | Modal/non-modal dialog window | `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/dialog.xhtml` |
| `p:confirmDialog` | Confirmation dialog (global/inline) | `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/confirmDialog.xhtml` |
| `p:confirmPopup` | Lightweight confirmation popup | `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/confirmPopup.xhtml` |
| `p:overlayPanel` | Anchored floating panel | `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/overlayPanel.xhtml` |
| `p:sidebar` | Slide-in side panel | `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/sidebar.xhtml` |
| `p:tooltip` | Hover tooltip | `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/tooltip/` |

## Dialog — canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/dialog.xhtml`.
Trigger with a button, define the dialog separately.

```xhtml
<p:commandButton value="Show" type="button" icon="pi pi-external-link"
                 onclick="PF('dlg1').show()"/>

<p:dialog header="Header" widgetVar="dlg1" width="350" showEffect="fade"
          modal="true" closeOnEscape="true" dismissibleMask="true">
    <p class="m-0">Content...</p>
</p:dialog>
```

## ConfirmDialog — global pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/overlay/confirmDialog.xhtml`
(bean `confirmView`). Declare one global `p:confirmDialog`, attach `p:confirm` to
any action component.

```xhtml
<p:confirmDialog global="true" showEffect="fade" hideEffect="fade" responsive="true">
    <p:commandButton value="No" type="button" styleClass="ui-confirmdialog-no" icon="pi pi-times"/>
    <p:commandButton value="Yes" type="button" styleClass="ui-confirmdialog-yes" icon="pi pi-check"/>
</p:confirmDialog>

<p:commandButton value="Delete" action="#{confirmView.delete}" update="message" icon="pi pi-times">
    <p:confirm header="Confirmation" message="Are you sure?" icon="pi pi-exclamation-triangle"/>
</p:commandButton>
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/overlay/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/overlay/`.
