---
name: primefaces-multimedia
description: >-
  How to build PrimeFaces multimedia components correctly, sourced from the
  vendored showcase. USE FOR: galleria, graphicImage, photoCam, cropper (image
  crop), media (audio/video/pdf), audio, video, imageCompare, barcode, qrcode —
  images, media playback, capture, and codes in JSF/Facelets.
---

# PrimeFaces multimedia components

Namespaces (Faces 4): `p="primefaces"`, `h="jakarta.faces.html"`,
`f="jakarta.faces.core"`. Images are served from resource libraries via
`p:graphicImage name="..." library="..."`. Capture/crop components post back to
a bean listener. See `.opencode/skills/primefaces/CONVENTIONS.md`.

## Components

| Component | Purpose | Example source |
|---|---|---|
| `p:galleria` | Image gallery/carousel with captions | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/galleria.xhtml` |
| `p:graphicImage` | Dynamic/streamed image rendering | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/graphicImage.xhtml` |
| `p:photoCam` | Webcam capture | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/photocam/photoCam.xhtml` |
| `p:imageCropper` | Crop an image | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/cropper/` |
| `p:media` | Embed pdf/audio/video by type | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/media.xhtml` |
| `p:audio` | Audio player | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/audio.xhtml` |
| `p:video` | Video player | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/video.xhtml` |
| `p:imageCompare` | Before/after image slider | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/compare.xhtml` |
| `p:barcode` | Render barcode | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/barcode.xhtml` |
| `p:qrCode` | Render QR code | `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/qrcode.xhtml` |

## Galleria — canonical pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/galleria.xhtml`
(bean `imagesView`). Iterate images with `var` and render each via `p:graphicImage`.

```xhtml
<p:galleria value="#{imagesView.images}" var="image" panelWidth="500"
            panelHeight="313" showCaption="true">
    <p:graphicImage name="demo/images/nature/#{image}" alt="#{image}" title="#{image}"/>
</p:galleria>
```

## PhotoCam — capture pattern

Source: `primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/photocam/photoCam.xhtml`
(bean `photoCamView`).

```xhtml
<h:form>
    <p:photoCam widgetVar="pc" listener="#{photoCamView.oncapture}" update="photo"/>
    <p:commandButton type="button" value="Capture" onclick="PF('pc').capture()"/>
    <p:outputPanel id="photo">
        <p:graphicImage name="demo/images/photocam/#{photoCamView.filename}.jpeg"
                        rendered="#{not empty photoCamView.filename}"/>
    </p:outputPanel>
</h:form>
```

```java
public void oncapture(CaptureEvent captureEvent) {
    byte[] data = captureEvent.getData();
    // persist captured image bytes
}
```

## See also

Full variants under
`primefaces/primefaces-showcase/src/main/webapp/ui/multimedia/` and beans under
`primefaces/primefaces-showcase/src/main/java/org/primefaces/showcase/view/multimedia/`.
