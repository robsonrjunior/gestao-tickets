---
name: primefaces-chart
description: >-
  How to build PrimeFaces charts correctly, sourced from the vendored showcase.
  USE FOR: p:chart with Chart.js models — bar, stacked bar, line, pie, doughnut,
  bubble, radar, polar area, scatter, mixed, custom charts, chart export, and
  itemSelect handling in JSF/Facelets.
---

# PrimeFaces chart component

PrimeFaces 16 uses a single `p:chart` component backed by Chart.js models. The
`value` attribute takes a chart model built in the bean. Namespaces (Faces 4):
`p="primefaces"`, `h="jakarta.faces.html"`, `f="jakarta.faces.core"`. See
`.opencode/skills/primefaces/CONVENTIONS.md`.

## Chart types

| Type | Example source |
|---|---|
| Bar / Stacked bar | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/bar.xhtml` |
| Line | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/line.xhtml` |
| Pie | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/pie.xhtml` |
| Doughnut | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/doughnut.xhtml` |
| Bubble | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/bubble.xhtml` |
| Radar | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/radar.xhtml` |
| Polar area | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/polararea.xhtml` |
| Scatter | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/scatter.xhtml` |
| Mixed | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/mixed.xhtml` |
| Custom | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/custom.xhtml` |
| Export | `primefaces/primefaces-showcase/src/main/webapp/ui/chart/export.xhtml` |

## Canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/chart/bar.xhtml`
(bean `chartView`, `primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/chartjs/ChartView.java`).

```xhtml
<h:form>
    <p:growl id="growl" showDetail="true"/>
    <div class="card">
        <h5>Bar</h5>
        <p:chart value="#{chartView.barModel}" style="width: 100%; height: 500px;">
            <p:ajax event="itemSelect" listener="#{chartView.itemSelect}" update="growl"/>
        </p:chart>
    </div>
</h:form>
```

```java
@Named
@RequestScoped
public class ChartView implements Serializable {
    private String barModel;

    @PostConstruct
    public void init() {
        // build a Chart.js model (data + options) and assign to barModel
        barModel = new BarChart()./* ... */toJson();
    }

    public String getBarModel() {
        return barModel;
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/chart/` and the model bean
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/chartjs/ChartView.java`.
