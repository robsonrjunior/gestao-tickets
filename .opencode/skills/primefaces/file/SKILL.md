---
name: primefaces-file
description: >-
  How to build PrimeFaces file components correctly, sourced from the vendored
  showcase. USE FOR: fileUpload (simple and advanced/ajax), fileDownload,
  validateFile, monitoring downloads — uploading and downloading files in
  JSF/Facelets.
---

# PrimeFaces file components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`. Upload forms
MUST set `enctype="multipart/form-data"`. The bean handles uploads via a
`listener` receiving a `FileUploadEvent`. See
`.opencode/skills/primefaces/CONVENTIONS.md`.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:fileUpload` (simple) | Basic single-file input | `primefaces/primefaces-showcase/src/main/webapp/ui/file/upload/simple.xhtml` |
| `p:fileUpload` (advanced) | Ajax drag/drop, multiple, progress, validation | `primefaces/primefaces-showcase/src/main/webapp/ui/file/upload/advanced.xhtml` |
| `p:fileDownload` | Stream a file to the browser | `primefaces/primefaces-showcase/src/main/webapp/ui/file/download.xhtml` |
| `p:validateFile` | Size/type/count constraints | (nested in advanced upload) |

## FileUpload — advanced/ajax pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/file/upload/advanced.xhtml`
(bean `fileUploadView`).

```xhtml
<h:form enctype="multipart/form-data">
    <p:fileUpload listener="#{fileUploadView.handleFileUpload}"
                  mode="advanced" multiple="true"
                  accept=".gif,.jpg,.jpeg,.png" update="growl">
        <p:validateFile sizeLimit="1000000" fileLimit="3"
                        allowTypes="/(\.|\/)(gif|jpeg|jpg|png)$/"/>
    </p:fileUpload>
    <p:growl id="growl" showDetail="true"/>
</h:form>
```

```java
public void handleFileUpload(FileUploadEvent event) {
    UploadedFile file = event.getFile();
    // store file.getContent() / file.getInputStream()
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Successful", file.getFileName() + " uploaded."));
}
```

## FileDownload — pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/file/download.xhtml`
(bean `fileDownloadView`). Downloads run with `ajax="false"`; monitor via
`PrimeFaces.monitorDownload`.

```xhtml
<p:commandButton value="Download" ajax="false"
                 onclick="PrimeFaces.monitorDownload(start, stop);" icon="pi pi-arrow-down">
    <p:fileDownload value="#{fileDownloadView.file}"/>
</p:commandButton>
```

```java
public StreamedContent getFile() {
    return DefaultStreamedContent.builder()
        .name("downloaded.png").contentType("image/png")
        .stream(() -> getClass().getResourceAsStream("/path/file.png"))
        .build();
}
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/file/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/file/`.
