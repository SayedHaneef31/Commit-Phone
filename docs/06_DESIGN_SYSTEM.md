# 06 — Design System

## Purpose
Defines the visual and tactile language.

## Design Intent

The interface should feel like:

> A premium keypad phone from an alternate 2026.

Not:
- a generic minimalist launcher
- a grayscale productivity dashboard
- a terminal theme
- a novelty retro toy

## Visual Character

| Dimension | Target |
|---|---:|
| Visual distraction | 2/10 |
| Boringness | 4/10 |
| Coolness | 4/10 |
| Retro feeling | 8/10 |
| Utility | 10/10 |

These are directional design targets, not literal metrics.

## Color

MVP:
- predominantly black
- restrained neutral text
- minimal semantic accent use

Do not add multiple colors merely for decoration.

## Typography

Use a highly legible system or licensed typeface that supports:
- numeric keypad
- compact menus
- status text
- long labels

Retro/pixel typography is optional and must not sacrifice readability.

## Layout

Target:
- screen area approximately 50–60%
- keypad/control area approximately 40–50%

Exact split must adapt to aspect ratio.

## Keypad

Visual hierarchy:
- number
- letters
- tactile press state
- focus state

Key surfaces must have sufficient spacing and hit area.

## D-pad

Clearly distinguish:
- navigation directions
- center/select

The D-pad should appear physically integrated with the keypad.

## Soft Keys

Use restrained labels:
- Menu
- Back
- Select
- Options
- Call
- End

Avoid long buttons and modern card-heavy layouts.

## Focus State

Focus must be obvious without relying only on color.

Use:
- outline
- inset
- scale/brightness change
- haptic where appropriate

## Motion

Motion should explain state:
- key press
- focus change
- screen transition
- modal entry/exit

Avoid:
- looping animations
- attention-grabbing motion
- reward-like effects

## Haptics

Optional and configurable.
Use short, purposeful feedback.

## Sound

Optional keypad clicks and system sounds may be implemented later.

## Icons

Simple, high-legibility icons.
Avoid icon forests.

## Dialogs

Dialogs should:
- explain one decision
- have clear primary action
- avoid manipulative wording
- preserve keypad navigation

## Accessibility

Must consider:
- minimum touch targets
- text scaling
- contrast
- focus visibility
- screen readers
- haptic/audio alternatives

## Theming

MVP: one canonical black theme.

Themes are intentionally deferred.
