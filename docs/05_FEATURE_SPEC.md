# 05 — Feature Specification

## Purpose
Detailed behavioral definition of major product features.

---

# 1. Launcher Shell

### Goal
Replace the conventional Android home experience with the keypad-phone experience.

### Must
- register as HOME-capable application
- render Home
- launch approved functions
- restore state after returning from apps
- handle lifecycle safely

### MVP
Custom Home/Menu/Keypad/D-pad.

---

# 2. Keypad

### Required keys
0–9, *, #.

### Required behavior
- visual press state
- optional haptic feedback
- numeric input
- context-sensitive actions
- future long-press mapping
- future T9 integration

### Keypad persistence
The keypad is visible on product-owned screens unless the screen is explicitly a full-screen exception.

---

# 3. D-pad

Controls:
- Up
- Down
- Left
- Right
- OK/Center

Requirements:
- deterministic focus
- obvious focus indicator
- no focus traps
- back/home semantics
- restoration after child screen closes

---

# 4. Soft Keys

Initial concept:
- Left soft key: Menu/context action
- Right soft key: Back/secondary action
- Center: OK/select

Exact mappings may vary by screen but should remain predictable.

---

# 5. App Discovery

Use Android-supported app/activity discovery mechanisms.

The launcher must maintain a normalized internal representation:

```text
AppRecord
- packageId
- activityId where needed
- label
- icon reference
- category
- policy state
- launch capability
```

---

# 6. App Policy

Every third-party application should have a policy state.

Possible states:
- CORE
- ALLOWED
- REVIEW
- TEMPORARY
- HIDDEN
- RESTRICTED
- DISALLOWED

The policy engine is authoritative for product-level visibility.

---

# 7. Commitment

Commitment is stateful.

It must survive:
- app restart
- process death
- device reboot
- normal configuration changes

The state must not rely solely on an in-memory flag.

---

# 8. App Cleanup

MVP:
- detect candidates
- show high-impact list
- guide supported uninstall actions
- hide/restrict unapproved applications where platform capabilities permit

Do not promise silent bulk uninstallation unless Android/device-management capabilities explicitly support the scenario.

---

# 9. Core Phone Functions

Initial strategy:
- integrate with native/device capabilities
- replace custom UI progressively

Functions:
- calls
- contacts
- SMS/MMS
- camera
- gallery
- clock
- calendar
- calculator
- notes
- files
- connectivity
- weather
- QR
- email
- browser

---

# 10. Modern Essential Apps

The launcher may expose:
- Maps
- UPI
- banking
- authenticator
- Duo
- WhatsApp
- work utilities

No built-in assumption that a specific application is required for every user.

---

# 11. Full-Screen Exception

An app can temporarily receive the full screen if:
- the task requires touch
- the app is not reasonably controllable through D-pad
- the screen cannot be meaningfully hosted inside the keypad shell

The user should return to the keypad environment after completing the task.

---

# 12. Notifications

MVP:
- no badges
- essential notifications preserved
- distracting notifications filtered/hidden according to policy

Future:
- batching
- notification summaries
- scheduled notification release

---

# 13. Browser

MVP:
- browser access remains possible
- browser is not promoted
- no browser feed on Home

Future:
- controlled browser
- domain/category policy
- safer search experience

---

# 14. Settings

Settings should expose product controls without recreating the full Android Settings tree.

Protected areas:
- commitment
- restrictions
- allowed apps
- accountability

---

# 15. Emergency

Emergency calling and safety mechanisms must not be broken by launcher behavior.

---

# 16. Future Features

Not MVP:
- custom T9 keyboard
- controlled browser
- temporary app scheduling
- custom contacts
- custom messages
- usage analytics
- account-based accountability
- themes
- hardware ecosystem
