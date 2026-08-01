---
name: primeflex-effects
description: >-
  How to apply visual effects with PrimeFlex 3.3.1 CSS utility classes. USE
  FOR: opacity (fade/dim), elevation/shadows (shadow-1..8, shadow-none),
  cursor (auto/pointer/wait/move), user-select (none/text/all/auto),
  pointer-events (none/auto), appearance-none — visual effects and
  interaction cues in JSF/Facelets.
---

# PrimeFlex effects utilities

Effects utilities control opacity, box-shadow elevation, cursor, user-select,
pointer-events, and appearance. Apply via `styleClass` on `p:` components
or `class` on plain markup. See `.opencode/skills/primeflex/CONVENTIONS.md`.

Responsive prefixes (`sm:`, `md:`, `lg:`, `xl:`) are supported for
opacity and shadow classes. State prefixes (`hover:`, `focus:`, `active:`)
are supported for opacity, shadows, and cursor classes.

## Opacity

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/opacity/classesdoc.js`.

| Class | Properties |
|---|---|
| `opacity-0` | `opacity: 0;` |
| `opacity-10` | `opacity: .1;` |
| `opacity-20` | `opacity: .2;` |
| `opacity-30` | `opacity: .3;` |
| `opacity-40` | `opacity: .4;` |
| `opacity-50` | `opacity: .5;` |
| `opacity-60` | `opacity: .6;` |
| `opacity-70` | `opacity: .7;` |
| `opacity-80` | `opacity: .8;` |
| `opacity-90` | `opacity: .9;` |
| `opacity-100` | `opacity: 1;` |

## Elevation / Shadow

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/elevation/classesdoc.js`.

| Class | Properties |
|---|---|
| `shadow-none` | `box-shadow: none;` |
| `shadow-1` | `box-shadow: 0px 3px 5px rgba(0,0,0,0.02), 0px 0px 2px rgba(0,0,0,0.05), 0px 1px 4px rgba(0,0,0,0.08);` |
| `shadow-2` | `box-shadow: 0px 4px 10px rgba(0,0,0,0.03), 0px 0px 2px rgba(0,0,0,0.06), 0px 2px 6px rgba(0,0,0,0.12);` |
| `shadow-3` | `box-shadow: 0px 1px 8px rgba(0,0,0,0.08), 0px 3px 4px rgba(0,0,0,0.1), 0px 1px 4px -1px rgba(0,0,0,0.1);` |
| `shadow-4` | `box-shadow: 0px 1px 10px rgba(0,0,0,0.12), 0px 4px 5px rgba(0,0,0,0.14), 0px 2px 4px -1px rgba(0,0,0,0.2);` |
| `shadow-5` | `box-shadow: 0px 1px 7px rgba(0,0,0,0.1), 0px 4px 5px -2px rgba(0,0,0,0.12), 0px 10px 15px -5px rgba(0,0,0,0.2);` |
| `shadow-6` | `box-shadow: 0px 3px 5px rgba(0,0,0,0.06), 0px 7px 9px rgba(0,0,0,0.12), 0px 20px 25px -8px rgba(0,0,0,0.18);` |
| `shadow-7` | `box-shadow: 0px 7px 30px rgba(0,0,0,0.08), 0px 22px 30px 2px rgba(0,0,0,0.15), 0px 8px 10px rgba(0,0,0,0.15);` |
| `shadow-8` | `box-shadow: 0px 9px 46px 8px rgba(0,0,0,0.12), 0px 24px 38px 3px rgba(0,0,0,0.14), 0px 11px 15px rgba(0,0,0,0.2);` |

## Cursor

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/cursor/classesdoc.js`.

| Class | Properties |
|---|---|
| `cursor-auto` | `cursor: auto;` |
| `cursor-pointer` | `cursor: pointer;` |
| `cursor-wait` | `cursor: wait;` |
| `cursor-move` | `cursor: move;` |

## User select

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/userselect/classesdoc.js`.

| Class | Properties |
|---|---|
| `select-none` | `user-select: none;` |
| `select-text` | `user-select: text;` |
| `select-all` | `user-select: all;` |
| `select-auto` | `user-select: auto;` |

## Pointer events

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/pointerevents/classesdoc.js`.

| Class | Properties |
|---|---|
| `pointer-events-none` | `pointer-events: none;` |
| `pointer-events-auto` | `pointer-events: auto;` |

## Appearance

Source: `primeflex-3.3.1/primeflex-3.3.1/components/doc/appearance/classesdoc.js`.

| Class | Properties |
|---|---|
| `appearance-none` | `appearance: none;` |

## XHTML snippet

```xhtml
<div class="shadow-2 p-3 border-round-lg cursor-pointer hover:shadow-4 transition-all transition-duration-200">
  <h3 class="mt-0 select-none">Interactive card</h3>
  <p class="opacity-70">Hover me — shadow elevates, cursor becomes pointer.</p>
  <button class="appearance-none border-none bg-primary text-white border-round p-2 cursor-pointer">
    Clickable
  </button>
  <div class="pointer-events-none opacity-50 mt-2 select-none">
    Disabled overlay — no clicks pass through
  </div>
</div>
```

## Source

- `primeflex-3.3.1/primeflex-3.3.1/components/doc/opacity/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/elevation/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/cursor/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/userselect/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/pointerevents/`
- `primeflex-3.3.1/primeflex-3.3.1/components/doc/appearance/`
