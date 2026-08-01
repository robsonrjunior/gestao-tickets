---
name: primefaces-misc
description: >-
  How to build PrimeFaces miscellaneous/utility components correctly, sourced
  from the vendored showcase. USE FOR: terminal, badge, tag, chip, avatar,
  progressBar, blockUI, spotlight, skeleton, clock, scrollTop, sticky, resizable,
  effect, hotkey, focus, defaultCommand, outputLabel, floatLabel, printer,
  idleMonitor, importConstants/importEnum, autoUpdate — utility widgets and
  behaviors in JSF/Facelets.
---

# PrimeFaces misc components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. This family is a grab-bag of small display widgets and
client-side behaviors. See `.opencode/skills/primefaces/CONVENTIONS.md`.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:terminal` | Interactive command terminal | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/terminal/basic.xhtml` |
| `p:badge` | Numeric/status badge overlay | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/badge.xhtml` |
| `p:tag` | Inline status tag | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/tag.xhtml` |
| `p:chip` | Compact info chip | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/chip.xhtml` |
| `p:avatar` | User/entity avatar | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/avatar.xhtml` |
| `p:progressBar` | Determinate/ajax progress | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/progressBar.xhtml` |
| `p:blockUI` | Block a region during ajax | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/blockUI.xhtml` |
| `p:spotlight` | Highlight a target element | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/spotlight.xhtml` |
| `p:skeleton` | Loading placeholder | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/skeleton.xhtml` |
| `p:clock` | Client/server clock | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/clock.xhtml` |
| `p:scrollTop` | Scroll-to-top button | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/scrollTop.xhtml` |
| `p:sticky` | Pin element on scroll | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/sticky.xhtml` |
| `p:resizable` | Make an element resizable | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/resizable.xhtml` |
| `p:defaultCommand` | Default action on Enter | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/defaultcommand/` |
| `p:outputLabel` | Accessible label for inputs | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/outputLabel.xhtml` |
| `p:hotkey` | Bind keyboard shortcuts | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/hotkey.xhtml` |
| `p:focus` | Auto-focus a field | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/focus.xhtml` |
| `p:autoUpdate` | Auto-update on every ajax | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/autoUpdate.xhtml` |
| `p:importEnum` / `p:importConstants` | Expose enums/constants to EL | `primefaces/primefaces-showcase/src/main/webapp/ui/misc/importEnum.xhtml` |

## Terminal — canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/misc/terminal/basic.xhtml`
(bean `terminalBasicView`). Provide a `commandHandler` returning output text.

```xhtml
<h:form>
    <p:focus for="terminal"/>
    <p:terminal id="terminal" widgetVar="term"
                commandHandler="#{terminalBasicView.handleCommand}"
                welcomeMessage="Welcome to PrimeFaces Terminal"/>
    <p:commandButton type="button" value="Clear" icon="pi pi-trash" onclick="PF('term').clear()"/>
</h:form>
```

```java
public String handleCommand(String command, String[] params) {
    if ("greet".equals(command)) {
        return "Hello " + (params.length > 0 ? params[0] : "guest");
    }
    return command + ": command not found";
}
```

## Badge / Tag / Avatar (display-only)

```xhtml
<p:badge value="3" severity="danger"><i class="pi pi-bell"/></p:badge>
<p:tag value="New" severity="success"/>
<p:avatar label="ML" shape="circle"/>
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/misc/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/misc/`.
