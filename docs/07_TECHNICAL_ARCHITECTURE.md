# 07 — Technical Architecture

## Purpose
Defines the software architecture and engineering boundaries.

## Target Stack

- Kotlin
- Android SDK
- Jetpack Compose
- Gradle Kotlin DSL
- Hilt
- DataStore
- Room only where structured local persistence is justified
- Kotlin coroutines/Flow
- AndroidX libraries as required
- JUnit
- Android instrumentation/UI testing

No cross-platform UI framework is planned.

---

# 1. Architectural Goals

1. Lightweight runtime.
2. Clear separation between UI and policy.
3. Android-native integrations.
4. Broad OEM compatibility.
5. Testable domain logic.
6. Safe failure and recovery.
7. Minimal background activity.
8. Avoid premature backend architecture.

---

# 2. Suggested Module Structure

```text
app/
core/
  common/
  model/
  navigation/
  permissions/
  platform/
  ui/
features/
  home/
  menu/
  keypad/
  apps/
  commitment/
  notifications/
  settings/
  phone/
  contacts/
  messaging/
  utilities/
services/
  appdiscovery/
  policy/
  commitment/
  notification/
data/
  local/
  repository/
```

The exact Gradle module split should remain proportional to complexity. Do not create dozens of modules for a small MVP.

---

# 3. Layering

```text
Compose UI
    ↓
ViewModel / UI State
    ↓
Use Cases
    ↓
Repositories
    ↓
Android Platform Adapters / Local Data
```

UI must not directly implement:
- app policy
- commitment rules
- permission decision logic
- device-management logic

---

# 4. Domain Concepts

Core domain models should include:

```text
AppRecord
AppPolicy
CommitmentState
RestrictionPolicy
EssentialApp
PermissionState
NotificationPolicy
```

---

# 5. State Management

Use immutable UI state where practical.

Example:

```kotlin
data class HomeUiState(
    val time: String,
    val date: String,
    val focusedControl: HomeControl,
    val connectionState: ConnectionState,
    val menuOpen: Boolean
)
```

Flow/state ownership must be explicit.

---

# 6. Navigation

Use a small deterministic navigation model rather than a browser-like navigation stack everywhere.

Each screen should define:
- entry state
- exit behavior
- focus restoration
- keypad mapping
- D-pad mapping

---

# 7. Repository Boundaries

Examples:

```text
AppRepository
CommitmentRepository
PolicyRepository
SettingsRepository
NotificationRepository
ContactRepository
SystemSettingsRepository
```

Android-specific code should be isolated behind interfaces where practical.

---

# 8. Policy Engine

Policy engine should be a pure/testable domain component as much as possible.

Input:
- app metadata
- known classification
- user reason
- current commitment mode

Output:
- allow/review/deny
- rationale
- permitted launch mode

---

# 9. Commitment Engine

The commitment engine owns:
- current mode
- activation time
- lock period
- protected settings
- exit requirements
- accountability requirement
- restriction level

It must be persisted and recoverable across process death and reboot.

---

# 10. Services

Use Android services only where required.

Potential examples:
- notification listener
- accessibility integration if ultimately justified
- device policy interactions where provisioned
- input method in future

Do not keep unnecessary always-on services.

---

# 11. Error Handling

All platform interactions should have explicit failure paths.

Examples:
- permission denied
- activity unavailable
- package removed
- OEM-specific behavior
- API unavailable

UI should surface a useful fallback rather than crash.

---

# 12. Logging

Development logs must avoid sensitive user data.

Production logs should be minimal.

Never log:
- authentication codes
- private message contents
- banking details
- accountability PIN
- unnecessary contact details

---

# 13. Dependency Rules

Before adding a dependency:
1. verify the Android SDK/AndroidX does not already solve the problem
2. justify why the dependency is needed
3. evaluate size, maintenance, and privacy
4. record material architectural decisions

---

# 14. Performance

Avoid:
- unnecessary recomposition
- large image caches
- constant polling
- frequent background work
- unnecessary wakeups

The launcher should feel instant.

---

# 15. Future Architecture

Potential future subsystems:
- T9 IME
- controlled browser
- remote accountability
- richer policy model
- custom system utility apps

These should not be implemented until the MVP proves the core hypothesis.
