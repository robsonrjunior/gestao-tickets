---
name: primefaces-menu
description: >-
  How to build PrimeFaces navigation/menu components correctly, sourced from the
  vendored showcase. USE FOR: menu, menubar, tieredMenu, slideMenu, megaMenu,
  panelMenu, breadCrumb, contextMenu, menuButton, tabMenu, steps, dock, stack —
  navigation and command menus in JSF/Facelets, including programmatic MenuModel.
---

# PrimeFaces menu components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. Menus are built declaratively with
`p:submenu`/`p:menuitem`, or programmatically from a `MenuModel` bean via the
`model` attribute. `p:menuitem` supports `action`, `url`, or `outcome`, plus
`icon` (PrimeIcons `pi pi-*`). See `.opencode/skills/primefaces/CONVENTIONS.md`.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:menu` | Inline or overlay menu | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/menu.xhtml` |
| `p:menubar` | Horizontal app menu bar | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/menubar.xhtml` |
| `p:tieredMenu` | Multi-level submenu menu | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/tieredMenu.xhtml` |
| `p:slideMenu` | Sliding multi-level menu | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/slideMenu.xhtml` |
| `p:megaMenu` | Column-grouped mega menu | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/megaMenu.xhtml` |
| `p:panelMenu` | Accordion-style side menu | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/panelMenu.xhtml` |
| `p:breadCrumb` | Breadcrumb trail | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/breadcrumb.xhtml` |
| `p:contextMenu` | Right-click context menu | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/contextmenu/` |
| `p:menuButton` | Button with dropdown items | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/menuButton.xhtml` |
| `p:tabMenu` | Tab-styled navigation | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/tabMenu.xhtml` |
| `p:steps` | Wizard-style step indicator | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/steps.xhtml` |
| `p:dock` | macOS-style dock | `primefaces/primefaces-showcase/src/main/webapp/ui/menu/dock.xhtml` |

## Menu — declarative pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/menu/menu.xhtml`
(bean `menuView`).

```xhtml
<h:form>
    <p:growl id="messages" showDetail="true"/>
    <p:menu>
        <p:submenu label="Options">
            <p:menuitem value="Update" action="#{menuView.update}" update="messages" icon="pi pi-refresh"/>
            <p:menuitem value="Delete" action="#{menuView.delete}" update="messages" icon="pi pi-times"/>
        </p:submenu>
        <p:submenu label="Navigations">
            <p:menuitem value="Website" url="https://www.primefaces.org" icon="pi pi-external-link"/>
            <p:menuitem value="Internal" outcome="/ui/menu/menubar" icon="pi pi-upload"/>
        </p:submenu>
    </p:menu>
</h:form>
```

## Menubar with nested submenus

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/menu/menubar.xhtml`.

```xhtml
<p:menubar>
    <f:facet name="start">
        <p:graphicImage name="images/logo.svg" library="showcase"/>
    </f:facet>
    <p:submenu label="File" icon="pi pi-fw pi-file">
        <p:submenu label="New" icon="pi pi-fw pi-plus">
            <p:menuitem value="Bookmark" icon="pi pi-fw pi-bookmark"/>
        </p:submenu>
        <p:divider/>
        <p:menuitem value="Export" icon="pi pi-fw pi-external-link"/>
    </p:submenu>
</p:menubar>
```

## Programmatic MenuModel pattern

Build a `MenuModel` in the bean and pass it via `model`. Source bean:
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/menu/MenuView.java`.

```xhtml
<p:menu model="#{menuView.model}"/>
```

```java
@Named("menuView")
@ViewScoped
public class MenuView implements Serializable {
    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        DefaultSubMenu submenu = DefaultSubMenu.builder().label("Options").build();
        submenu.getElements().add(DefaultMenuItem.builder()
                .value("Save").icon("pi pi-save").command("#{menuView.save}").build());
        model.getElements().add(submenu);
    }

    public MenuModel getModel() {
        return model;
    }
}
```

## ContextMenu

Attach to a target component via `for`. See
`primefaces/primefaces-showcase/src/main/webapp/ui/menu/contextmenu/`.

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/menu/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/menu/`.
