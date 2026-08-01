---
name: primefaces-data
description: >-
  How to build PrimeFaces data-display components correctly, sourced from the
  vendored showcase. USE FOR: dataTable, dataView, dataList, dataGrid,
  dataScroller, treeTable, tree, schedule, carousel, orderList, pickList,
  timeline, dataExporter — displaying, paginating, sorting, filtering, editing,
  selecting, or CRUD-ing tabular/collection/hierarchical data in JSF/Facelets.
---

# PrimeFaces data components

Facelets namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`, `ui="jakarta.faces.facelets"`.

Backing beans use `@Named` + `@ViewScoped`, `implements Serializable`, with data
loaded in a `@PostConstruct` `init()` (see `.opencode/skills/primefaces/CONVENTIONS.md`).

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:dataTable` | Tabular data with paging, sort, filter, edit, selection, CRUD, grouping, lazy loading | `primefaces/primefaces-showcase/src/main/webapp/ui/data/datatable/basic.xhtml` |
| `p:dataView` | Toggle between grid and list layouts for a collection | `primefaces/primefaces-showcase/src/main/webapp/ui/data/dataview/basic.xhtml` |
| `p:dataList` | Ordered/unordered/definition list of items | `primefaces/primefaces-showcase/src/main/webapp/ui/data/datalist/basic.xhtml` |
| `p:dataGrid` | Grid layout of repeating items | `primefaces/primefaces-showcase/src/main/webapp/ui/data/datagrid/` |
| `p:dataScroller` | Infinite/scroll-based lazy list | `primefaces/primefaces-showcase/src/main/webapp/ui/data/datascroller/` |
| `p:treeTable` | Hierarchical data in tabular form | `primefaces/primefaces-showcase/src/main/webapp/ui/data/treetable/basic.xhtml` |
| `p:tree` | Hierarchical tree with selection/DnD/lazy nodes | `primefaces/primefaces-showcase/src/main/webapp/ui/data/tree/basic.xhtml` |
| `p:schedule` | Calendar/event scheduler | `primefaces/primefaces-showcase/src/main/webapp/ui/data/schedule/` |
| `p:carousel` | Rotating/paged item viewer | `primefaces/primefaces-showcase/src/main/webapp/ui/data/carousel.xhtml` |
| `p:orderList` | Reorderable list | `primefaces/primefaces-showcase/src/main/webapp/ui/data/orderList.xhtml` |
| `p:pickList` | Dual-list source/target transfer | `primefaces/primefaces-showcase/src/main/webapp/ui/data/pickList.xhtml` |
| `p:timeline` | Chronological event timeline | `primefaces/primefaces-showcase/src/main/webapp/ui/data/timeline/` |
| `p:dataExporter` | Export table data (PDF/XLS/CSV) | `primefaces/primefaces-showcase/src/main/webapp/ui/data/dataexporter/` |

## DataTable — canonical pattern

Basic table. Source: `primefaces/primefaces-showcase/src/main/webapp/ui/data/datatable/basic.xhtml`,
bean `primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/data/datatable/BasicView.java`.

```xhtml
<h:form>
    <p:dataTable var="product" value="#{dtBasicView.products}">
        <p:column headerText="Code">
            <h:outputText value="#{product.code}"/>
        </p:column>
        <p:column headerText="Name">
            <h:outputText value="#{product.name}"/>
        </p:column>
        <p:column headerText="Category">
            <h:outputText value="#{product.category}"/>
        </p:column>
    </p:dataTable>
</h:form>
```

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

### Common DataTable variants

- **Pagination/sort/filter**: add `paginator="true" rows="10"`, `sortBy` and
  `filterBy` on `p:column`. See `datatable/filter.xhtml`, `datatable/sort.xhtml`.
- **Selection**: `selectionMode`/`p:column selectionMode="multiple"` bound via
  `selection` + `rowKey`. See
  `primefaces/primefaces-showcase/src/main/webapp/ui/data/datatable/selection.xhtml`
  (bean `.../view/data/datatable/SelectionView.java`).
- **Inline edit**: wrap cells in `p:cellEditor` with `p:rowEditor`. See
  `primefaces/primefaces-showcase/src/main/webapp/ui/data/datatable/edit.xhtml`
  (bean `.../view/data/datatable/EditView.java`).
- **CRUD** (dialog add/edit/delete): see
  `primefaces/primefaces-showcase/src/main/webapp/ui/data/datatable/crud.xhtml`
  (bean `.../view/data/datatable/CrudView.java`).
- **Lazy loading**: `LazyDataModel`. See `datatable/lazy.xhtml` +
  `.../view/data/datatable/LazyView.java`, `LazyCustomerDataModel.java`.

## DataView — grid/list toggle

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/data/dataview/basic.xhtml`
(bean `dataGridView`).

```xhtml
<p:dataView var="product" value="#{dataGridView.products}" rows="12" paginator="true"
            gridIcon="pi pi-th-large" listIcon="pi pi-bars">
    <p:dataViewGridItem>
        <!-- grid layout markup for #{product} -->
    </p:dataViewGridItem>
    <p:dataViewListItem>
        <!-- list layout markup for #{product} -->
    </p:dataViewListItem>
</p:dataView>
```

## DataList

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/data/datalist/basic.xhtml`.

```xhtml
<p:dataList value="#{dataListView.products1}" var="product" type="ordered">
    <div class="product-name">#{product.name}</div>
    <p:rating readonly="true" value="#{product.rating}"/>
</p:dataList>
```

## TreeTable

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/data/treetable/basic.xhtml`
(bean `ttBasicView`, `.../view/data/treetable/BasicView.java`). `value` is a
`TreeNode` root.

```xhtml
<p:treeTable value="#{ttBasicView.root}" var="document">
    <p:column headerText="Name"><h:outputText value="#{document.name}"/></p:column>
    <p:column headerText="Size"><h:outputText value="#{document.size}"/></p:column>
    <p:column headerText="Type"><h:outputText value="#{document.type}"/></p:column>
</p:treeTable>
```

## Tree

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/data/tree/basic.xhtml`
(bean `treeBasicView`). Use `dynamic="true"` for ajax lazy nodes.

```xhtml
<p:tree value="#{treeBasicView.root}" var="node">
    <p:treeNode>
        <h:outputText value="#{node}"/>
    </p:treeNode>
</p:tree>
```

## Schedule

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/data/schedule/`
(bean `.../view/data/ScheduleJava8View.java`). Bind a `ScheduleModel` via
`value` and handle `dateSelect`/`eventSelect` ajax events.

## See also

Browse the full set of variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/data/` and their beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/data/`.
