# PrimeFaces Showcase Skills — Authoring Conventions

Shared conventions for every skill under `.opencode/skills/primefaces/<family>/`.
These skills teach how to build PrimeFaces components correctly for
Jakarta EE (Faces 4, Java 21) applications.

## Source of truth

All patterns are distilled from the vendored PrimeFaces showcase:

- XHTML views: `primefaces/primefaces-showcase/src/main/webapp/ui/<family>/**`
- Backing beans: `primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/<family>/**`

Showcase version: **PrimeFaces 16.0.0** (see `primefaces/primefaces-showcase/pom.xml`).
Treat everything under `primefaces/` as read-only. Do not copy the license
header; link to files instead.

## Family → source directory map

| Skill family | XHTML source dir | Bean source dir |
|---|---|---|
| data | `ui/data/**` | `view/data/**` |
| input | `ui/input/**` | `view/input/**` |
| panel | `ui/panel/**` | `view/panel/**` |
| menu | `ui/menu/**` | `view/menu/**` |
| overlay | `ui/overlay/**` | `view/overlay/**` |
| file | `ui/file/**` | `view/file/**` |
| button | `ui/button/**` | `view/button/**` |
| message | `ui/message/**` | `view/message/**` |
| chart | `ui/chart/**` | `view/chartjs/**` |
| multimedia | `ui/multimedia/**` | `view/multimedia/**` |
| misc | `ui/misc/**` | `view/misc/**` |

(Paths are relative to `primefaces/primefaces-showcase/src/main/`.)

## SKILL.md structure

Each family skill MUST have:

1. **YAML frontmatter** with:
   - `name`: `primefaces-<family>`
   - `description`: one paragraph that says WHEN to use it and lists the
     components covered ("USE FOR: ...").
2. **Body sections**:
   - Short intro (namespaces + what the family covers).
   - A component table: component, purpose, source example path.
   - Canonical XHTML snippet(s) for representative components.
   - Backing-bean pattern when the component needs one.
   - "See also" links to the full showcase examples.

## Namespaces (Faces 4 / Jakarta)

```xhtml
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="jakarta.faces.facelets"
xmlns:h="jakarta.faces.html"
xmlns:f="jakarta.faces.core"
xmlns:p="primefaces"
```

## Backing-bean pattern

Showcase beans use CDI (`@Named`) with `@ViewScoped` and implement
`Serializable`; dependencies are `@Inject`ed and initialized in a
`@PostConstruct` method.

```java
@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
    @Inject
    private ProductService service;

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = service.getProducts(10);
    }

    public List<Product> getProducts() {
        return products;
    }
}
```

## Source-linking rule

Every documented component MUST cite its repo-relative showcase XHTML path, and
the backing-bean path when one exists, using `file_path` references so a reader
can open the full working example.
