# 15 — Navigation and Interaction Specification

## Purpose
Defines how the phone is operated.

## Interaction Hierarchy

```text
D-pad
↓
Numeric keypad
↓
Physical/input-device controls
↓
Touch when necessary
```

---

# 1. Home Controls

Home should define predictable focus order.

Example:

```text
Status
↓
Primary soft-key action
↓
Menu
↓
Keypad
↓
System actions
```

Exact focus order is subject to usability testing.

---

# 2. D-pad

Up/down:
- move through lists
- move focus vertically

Left/right:
- horizontal navigation where available
- change tabs/options only where explicitly defined

OK:
- activate focused action

Back:
- return one logical level

Home:
- return to phone Home

Call:
- enter/confirm phone call flow where contextually appropriate

End:
- terminate call or return toward Home according to platform behavior

---

# 3. Keypad

Numeric keys may:
- enter numbers
- select menu shortcuts in future
- initiate T9 in future
- perform context actions

Avoid inconsistent remapping.

---

# 4. Touch

Touch is valid where:
- a modern app requires it
- D-pad would create unacceptable friction
- precision interaction is required
- accessibility requires it

Touch should not automatically become the dominant navigation method.

---

# 5. Focus Restoration

When returning from:
- menu
- dialog
- external app
- settings

restore focus to the most reasonable prior element.

No "focus disappears" state is acceptable in a production flow.

---

# 6. Long Press

Future:
- speed dial
- shortcuts
- character entry
- secondary keypad functions

Not required for first clickable prototype.

---

# 7. Gesture Policy

Gestures are not part of the initial interaction model.

Do not add swipe-heavy navigation unless a concrete usability problem requires it.

---

# 8. Full-Screen App Transition

When external app starts:
- save launcher navigation context
- allow external app to control its UI
- do not overlay launcher UI without a supported reason
- restore launcher state on return

---

# 9. Accessibility

All product-owned navigation must have an equivalent non-touch path where practical.

Focus should be visible and robust.

---

# 10. Interaction Consistency

Same action should generally have same semantic meaning across screens.

Examples:
- OK = select
- Back = go back
- Home = phone Home
- numeric keys = numeric/keypad behavior
