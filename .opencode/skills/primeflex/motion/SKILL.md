---
name: primeflex-motion
description: >-
  How to apply animations, transitions, and transforms with PrimeFlex 3.3.1
  CSS utility classes. USE FOR: animations (fadein, fadeout, slidedown,
  slideup, scalein, fadeinleft/fadeinright/fadeinup/fadeindown and
  corresponding fadeouts, flip/flipleft/flipright/flipup, zoomin/zoomindown/
  zoominleft/zoominup/zoomninright, animate-width), animation delay/duration/
  fill/iteration/timing, transitions (transition-none, transition-all,
  transition-colors, transition-transform, transition-duration/delay/easing),
  transform origin, rotate, translate — motion and animation in JSF/Facelets.
---

# PrimeFlex motion utilities

Motion utilities control CSS animations, transitions, and transforms. Apply
via `styleClass` on `p:` components or `class` on plain markup. See
`.opencode/skills/primeflex/CONVENTIONS.md`.

Responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`) are supported. State
prefixes (`hover:`, `focus:`, `active:`) are supported for transition
and transform classes.

## Animations

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/animations/classesdoc.js`.

| Class | Description |
|---|---|
| `fadein` | Fade from opacity 0 to 1 |
| `fadeout` | Fade from opacity 1 to 0 |
| `slidedown` | Expand max-height from 0 to auto |
| `slideup` | Collapse max-height from 1000px to 0 |
| `scalein` | Scale from scaleY(0.8)/opacity 0 to scaleY(1)/opacity 1 |
| `fadeinleft` | Fade in + translateX(-100%) to translateX(0%) |
| `fadeoutleft` | Fade in + translateX(0%) to translateX(-100%) (exit left) |
| `fadeinright` | Fade in + translateX(100%) to translateX(0%) |
| `fadeoutright` | Fade in + translateX(0%) to translateX(100%) (exit right) |
| `fadeinup` | Fade in + translateY(-100%) to translateY(0%) |
| `fadeoutup` | Fade in + translateY(0%) to translateY(-100%) (exit up) |
| `fadeindown` | Fade in + translateY(100%) to translateY(0%) |
| `fadeoutdown` | Fade in + translateY(0%) to translateY(100%) (exit down) |
| `animate-width` | Expand width from 0 to 100% |
| `flip` | Perspective rotateX from -100deg to 0 |
| `flipleft` | Perspective rotateY from -100deg/opacity 0 to 0/opacity 1 |
| `flipright` | Perspective rotateY from 100deg/opacity 0 to 0/opacity 1 |
| `flipup` | Perspective rotateX from -100deg/opacity 0 to 0/opacity 1 |
| `zoomin` | Scale from scale3d(0.3,0.3,0.3)/opacity 0 to 1 |
| `zoomindown` | Zoom in from above (scale3d + translate3d) |
| `zoominleft` | Zoom in from left (scale3d + translate3d) |
| `zoominup` | Zoom in from below (scale3d + translate3d) |
| `zoominright` | Zoom in from right (scale3d + translate3d) |

Default durations: 0.15s for most animations (`slidedown`/`slideup` use 0.45s,
`animate-width` uses 1000ms). Default timing: `linear` for most, except
`slidedown` uses `ease-in-out` and `slideup` uses `cubic-bezier(0, 1, 0, 1)`.
Override with the animation-duration and animation-timing classes below.

## Animation delay

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationdelay/classesdoc.js`.

`animation-delay-{100,150,200,300,400,500,1000}` — sets `animation-delay` in ms.

## Animation duration

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationduration/classesdoc.js`.

`animation-duration-{100,150,200,300,400,500,1000,2000,3000}` — sets
`animation-duration` in ms.

## Animation fill

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationfill/classesdoc.js`.

| Class | Properties |
|---|---|
| `animation-fill-none` | `animation-fill-mode: none;` |
| `animation-fill-forwards` | `animation-fill-mode: forwards;` |
| `animation-fill-backwards` | `animation-fill-mode: backwards;` |
| `animation-fill-both` | `animation-fill-mode: both;` |

## Animation iteration

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationiteration/classesdoc.js`.

| Class | Properties |
|---|---|
| `animation-iteration-1` | `animation-iteration-count: 1;` |
| `animation-iteration-2` | `animation-iteration-count: 2;` |
| `animation-iteration-infinite` | `animation-iteration-count: infinite;` |

## Animation timing function

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationtimingfunction/classesdoc.js`.

| Class | Properties |
|---|---|
| `animation-linear` | `animation-timing-function: linear;` |
| `animation-ease-in` | `animation-timing-function: cubic-bezier(0.4, 0, 1, 1);` |
| `animation-ease-out` | `animation-timing-function: cubic-bezier(0, 0, 0.2, 1);` |
| `animation-ease-in-out` | `animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);` |

## Transition delay

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitiondelay/classesdoc.js`.

`transition-delay-{100,150,200,300,400,500,1000}` — sets `transition-delay` in ms.

## Transition duration

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitionduration/classesdoc.js`.

`transition-duration-{100,150,200,300,400,500,1000,2000,3000}` — sets
`transition-duration` in ms.

## Transition property

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitionproperty/classesdoc.js`.

| Class | Properties |
|---|---|
| `transition-none` | `transition-property: none;` |
| `transition-all` | `transition-property: all;` |
| `transition-colors` | `transition-property: background-color,border-color,color;` |
| `transition-transform` | `transition-property: transform;` |

## Transition timing function

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitiontimingfunction/classesdoc.js`.

| Class | Properties |
|---|---|
| `transition-linear` | `transition-timing-function: linear;` |
| `transition-ease-in` | `transition-timing-function: cubic-bezier(0.4, 0, 1, 1);` |
| `transition-ease-out` | `transition-timing-function: cubic-bezier(0, 0, 0.2, 1);` |
| `transition-ease-in-out` | `transition-timing-function: cubic-bezier(0.4, 0, 0.2, 1);` |

## Transform origin

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/transformorigin/classesdoc.js`.

| Class | Properties |
|---|---|
| `origin-center` | `transform-origin: center;` |
| `origin-top` | `transform-origin: top;` |
| `origin-top-right` | `transform-origin: top right;` |
| `origin-right` | `transform-origin: right;` |
| `origin-bottom-right` | `transform-origin: bottom right;` |
| `origin-bottom` | `transform-origin: bottom;` |
| `origin-bottom-left` | `transform-origin: bottom left;` |
| `origin-left` | `transform-origin: left;` |
| `origin-top-left` | `transform-origin: top left;` |

## Rotate

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/rotate/classesdoc.js`.

| Class | Properties |
|---|---|
| `rotate-45` | `transform: rotate(45deg);` |
| `-rotate-45` | `transform: rotate(-45deg);` |
| `rotate-90` | `transform: rotate(90deg);` |
| `-rotate-90` | `transform: rotate(-90deg);` |
| `rotate-180` | `transform: rotate(180deg);` |
| `-rotate-180` | `transform: rotate(-180deg);` |

## Translate

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/translate/classesdoc.js`.

| Class | Properties |
|---|---|
| `translate-x-0` | `transform: translateX(0%);` |
| `translate-x-100` | `transform: translateX(100%);` |
| `-translate-x-100` | `transform: translateX(-100%);` |
| `translate-y-0` | `transform: translateY(0%);` |
| `translate-y-100` | `transform: translateY(100%);` |
| `-translate-y-100` | `transform: translateY(-100%);` |

## XHTML snippet

```xhtml
<div class="fadein animation-duration-500 p-3 border-round-lg shadow-2">
  <p:commandButton value="Hover me"
    styleClass="transition-all transition-duration-300 hover:shadow-4 hover:scalein ui-button-raised"/>

  <div class="mt-3 overflow-hidden">
    <div class="animate-width animation-duration-1000 animation-ease-out bg-primary"
         style="height: 4px;" />
  </div>

  <span class="select-none cursor-pointer transition-colors transition-duration-200 hover:text-primary">
    <i class="pi pi-chevron-right rotate-90 transition-all transition-duration-300" />
    Expandable section
  </span>
</div>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/animations/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationdelay/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationduration/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationfill/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationiteration/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/animationtimingfunction/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitiondelay/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitionduration/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitionproperty/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/transitiontimingfunction/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/transformorigin/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/rotate/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/translate/`
