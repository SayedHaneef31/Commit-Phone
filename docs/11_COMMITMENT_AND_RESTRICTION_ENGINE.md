# 11 — Commitment and Restriction Engine

## Purpose
Defines commitment states and protected configuration.

## Commitment Model

### TRIAL
- exploration
- keypad experience active
- strong UX change
- recovery remains relatively accessible

### COMMITTED
- app-policy restrictions
- stronger exit friction
- protected settings
- accountability option

### HARDCORE
- strongest supported restrictions
- strongest launcher protection
- managed-device capabilities where available
- essential apps only
- emergency recovery retained

---

# 1. Commitment State

Example:

```text
CommitmentState
- mode
- activatedAt
- protectionUntil
- configurationVersion
- accountabilityRequired
- emergencyRecoveryEnabled
- deviceManagementState
```

---

# 2. Trial

Target duration: approximately 3 days.

The duration should be configurable at development time, not hardcoded throughout the app.

---

# 3. Protected Configuration

Potential protected values:
- commitment mode
- approved app list
- temporary access policy
- restriction policy
- launcher role settings
- strong enforcement settings

---

# 4. Configuration Freeze

A protected setting may require:
- time interval expiration
- accountability PIN
- explicit confirmation
- stronger provisioning

The engine must distinguish:
- normal setting change
- protected commitment change
- emergency recovery

---

# 5. Accountability PIN

V1:
- local
- stored securely
- not displayed
- ideally created by another trusted person
- never logged

The product must not pretend the PIN is impossible to recover if the underlying device owner can reset the application/device.

---

# 6. Exit Model

### Trial
Low friction.

### Committed
Moderate/high friction.

### Hardcore
Highest available protection that Android legitimately supports.

---

# 7. Emergency Exit

Emergency exit must have a separate pathway from ordinary "I changed my mind."

It should prioritize:
1. device usability
2. safety
3. recovery
4. preserving data

---

# 8. State Persistence

Commitment state must survive:
- process restart
- phone reboot
- normal app update

Use durable local storage.

---

# 9. Enforcement Layers

The engine should separate:
- UI visibility
- launch-time policy
- package/application state
- settings protection
- device-management controls

This lets the product operate at different commitment strengths without coupling everything together.

---

# 10. Downgrade Behavior

If strong enforcement capability becomes unavailable:
- detect it
- record degraded state
- do not claim the device is still fully protected
- keep lower-level restrictions where possible
- explain next steps

---

# 11. No Silent Lockout

The engine must never create a state where:
- the user cannot make emergency calls
- Android recovery is impossible
- device setup is irreparably blocked
