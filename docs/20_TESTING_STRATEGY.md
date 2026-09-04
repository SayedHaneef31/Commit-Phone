# 20 — Testing Strategy

## Testing Philosophy

A launcher modifies a fundamental device interaction, so stability and recovery are more important than visual polish alone.

## Test Layers

### Unit
- policy rules
- commitment state transitions
- app categorization
- navigation rules
- data migrations

### UI
- keypad
- D-pad
- focus
- menus
- dialogs
- onboarding

### Instrumentation
- launcher role
- package discovery
- app launch
- lifecycle
- permission-state handling

### Device
- reboot
- default launcher selection
- app updates
- package removal
- permission revocation
- external app return

---

# Critical Scenarios

1. Launcher starts after cold boot.
2. User presses Home.
3. External app returns to launcher.
4. Device reboots while committed.
5. App process is killed.
6. Essential app is uninstalled.
7. Disallowed app is installed.
8. Notification access is revoked.
9. Device-management capability is unavailable.
10. Launcher crashes.
11. User attempts to exit commitment.
12. Emergency recovery is invoked.
13. Android updates.
14. Device has no network.
15. Device has low memory.
16. Multiple profiles/users exist.
17. OEM launcher behavior differs.

---

# Policy Tests

For every category:
- expected classification
- explanation
- override/review handling
- commitment behavior

---

# Security Tests

Verify:
- PIN is not logged
- sensitive notification content is not logged
- protected settings cannot be trivially changed in the intended mode
- debug bypasses are not present in release

---

# Regression Rule

Every fixed bug should receive a regression test when practical.

---

# Definition of Done for a Feature

A feature is complete when:
- implementation works
- negative cases are handled
- relevant tests pass
- docs are updated
- no P0 regression
- state survives expected lifecycle transitions
