---
name: primefaces-message
description: >-
  How to build PrimeFaces feedback/message components correctly, sourced from the
  vendored showcase. USE FOR: growl, messages, message, staticMessage — showing
  validation errors, FacesMessages, and notifications in JSF/Facelets.
---

# PrimeFaces message components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`. These render
`FacesMessage`s added in the bean (`FacesContext.addMessage`) or produced by
validation. Target a specific message via `for`; update them over ajax with
`update`. See `.opencode/skills/primefaces/CONVENTIONS.md`.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:growl` | Toast-style transient notifications | `primefaces/primefaces-showcase/src/main/webapp/ui/message/growl.xhtml` |
| `p:messages` | Inline list of all/global messages | `primefaces/primefaces-showcase/src/main/webapp/ui/message/messages.xhtml` |
| `p:message` | Single component-scoped message | `primefaces/primefaces-showcase/src/main/webapp/ui/message/messages.xhtml` |
| `p:staticMessage` | Fixed, non-FacesMessage banner | `primefaces/primefaces-showcase/src/main/webapp/ui/message/staticMessage.xhtml` |

## Growl — canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/message/growl.xhtml`
(bean `growlView`).

```xhtml
<h:form>
    <p:growl id="growl" showDetail="true"/>
    <p:growl id="growl-sticky" for="sticky-key" showDetail="true" sticky="true"/>

    <p:commandButton actionListener="#{growlView.showInfo}" update="growl" value="Info"/>
    <p:commandButton actionListener="#{growlView.showError}" update="growl" value="Error"
                     styleClass="ui-button-danger"/>
</h:form>
```

```java
public void showInfo() {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Message", "PrimeFaces Rocks."));
}
```

## Messages / message

```xhtml
<!-- All global messages -->
<p:messages showDetail="true" closable="true"/>

<!-- Message tied to a specific input -->
<p:inputText id="name" value="#{bean.name}" required="true"/>
<p:message for="name"/>
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/message/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/message/`.
