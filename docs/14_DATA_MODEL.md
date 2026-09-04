# 14 — Data Model

## Purpose
Defines minimal durable local state.

## Storage Strategy

Use:
- DataStore for small preferences/settings
- Room only for structured data, relationships, history, or query needs
- secure platform storage for secrets where appropriate

---

# 1. UserSettings

```text
UserSettings
- theme
- hapticsEnabled
- keypadSoundEnabled
- timeFormat
- dateFormat
- preferredHomeLayoutVersion
```

Avoid storing unnecessary behavioral information.

---

# 2. AppRecord

```text
AppRecord
- packageName
- activityName (nullable)
- label
- iconReference
- installState
- lastSeen
```

Do not persist large binary icon caches unless needed.

---

# 3. AppPolicy

```text
AppPolicy
- packageName
- category
- decision
- reason
- temporaryUntil (nullable)
- createdAt
- updatedAt
```

---

# 4. CommitmentState

```text
CommitmentState
- mode
- activatedAt
- protectionUntil
- policyVersion
- accountabilityEnabled
- enforcementCapability
- stateVersion
```

---

# 5. PermissionState

Do not duplicate system authority unnecessarily.

Possible cache:
```text
CapabilityState
- capability
- lastCheckedAt
- available
- degradedReason
```

The cache is informational; actual platform state remains authoritative.

---

# 6. Navigation State

Prefer in-memory state where durable persistence is not required.

Persist only what is useful across:
- process death
- rotation/configuration
- app return

---

# 7. Migration

All durable schemas must have explicit versioning.

Migration must:
- preserve commitment
- preserve allow/deny state
- fail safely
- never reset restrictions silently

---

# 8. Sensitive Data Rule

Never store:
- private message contents
- notification contents
- authentication codes
- banking data
- raw accountability PIN
unless a future, explicitly approved feature requires it.
