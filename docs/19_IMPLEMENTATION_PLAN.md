# 19 — Implementation Plan

## Goal

Build the product in stages that prove the core hypothesis early and avoid premature complexity.

---

# Phase 0 — Project Foundation

Deliver:
- Android project
- Kotlin
- Compose
- Hilt
- basic architecture
- CI/local checks
- documentation structure
- lint/formatting
- test foundation

Done when:
- clean build
- app launches
- tests execute
- agent can navigate project docs

---

# Phase 1 — Launcher Shell

Deliver:
- HOME-capable launcher
- Home screen
- time/date
- basic status
- menu
- back/home behavior

Done when:
- can set as default launcher
- home/return lifecycle works

---

# Phase 2 — Keypad + D-pad

Deliver:
- keypad
- D-pad
- focus model
- soft keys
- basic interaction feedback

Done when:
- core navigation is possible without touch

---

# Phase 3 — App Discovery

Deliver:
- detect launchable apps
- app normalization
- app launching
- app return state
- package change handling

---

# Phase 4 — Policy Engine

Deliver:
- categories
- allow/deny/review decisions
- protected app list
- disallowed app hiding
- policy persistence

---

# Phase 5 — Trial

Deliver:
- onboarding
- interactive demonstration
- 3-day trial state
- trial restrictions
- recovery

---

# Phase 6 — Essential Apps

Deliver:
- whitelist setup
- user-specific tool selection
- modern-app launching
- external app return

---

# Phase 7 — Cleanup

Deliver:
- distraction candidate detection
- assisted uninstall flow
- hidden/restricted app handling

---

# Phase 8 — Commitment

Deliver:
- commitment states
- protected settings
- accountability PIN
- exit friction
- recovery

---

# Phase 9 — Notifications / Permissions

Deliver:
- notification access integration if validated
- filtering model
- permission onboarding
- degraded-mode handling

---

# Phase 10 — System Integration

Prioritize:
- calls
- contacts
- SMS
- camera
- gallery
- clock
- calendar
- utilities

Use native experiences where possible.

---

# Phase 11 — Compatibility

Test representative devices/OEMs.
Track failures in compatibility matrix.

---

# Phase 12 — Polish

- animation
- haptics
- sound
- accessibility
- performance
- startup
- recovery

---

# Phase 13 — Release Candidate

Definition:
- no known P0 defects
- P1 issues documented
- upgrade path tested
- permissions reviewed
- store requirements reviewed
- compatibility status documented

---

# Work Rule

Do not jump to future phases merely because they are interesting.

Complete and validate the current phase first.
