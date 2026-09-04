# 13 — Security and Privacy

## Purpose
Defines privacy/security requirements for a product that may request powerful Android capabilities.

## Privacy Position

The product should make the strongest reasonable privacy promise that can actually be delivered.

Initial direction:
- no required account
- no required backend
- local-first core
- minimum necessary data
- no unnecessary telemetry

---

# 1. Sensitive Data

Treat as sensitive:
- contacts
- messages
- notifications
- app usage
- authentication information
- banking/payment information
- accountability PIN
- device-management state

The launcher should avoid collecting or persisting content unnecessarily.

---

# 2. Accountability PIN

Requirements:
- never log it
- never display after creation
- store only what is needed for verification
- use a secure platform storage mechanism where appropriate
- do not store a plaintext PIN if a verification-safe representation is possible

---

# 3. Notification Data

If notification access is enabled:
- process only what is required
- minimize persistence
- do not transmit notification contents to a server
- avoid logging notification text

---

# 4. Contacts/Messages

The launcher should prefer direct system-backed operations and avoid creating a duplicate archive.

Do not copy message/contact content into application storage unless a feature specifically requires it.

---

# 5. Network

Core launcher functions should not require internet.

If future features use network access:
- document why
- minimize data
- use TLS
- avoid sending content unnecessarily

---

# 6. Analytics

No analytics are required for MVP.

Future analytics must answer:
- what is collected?
- why?
- can it be anonymous?
- can the feature work without it?

---

# 7. Permissions

Every sensitive permission must have:
- product rationale
- timing rationale
- fallback
- revocation path

---

# 8. Threat Model

Consider:
- malicious application attempting to bypass restrictions
- user attempting accidental/intentional circumvention
- stolen/unlocked device
- compromised account in future
- corrupted local state
- misconfigured device-owner state
- accidental data exposure through logs

---

# 9. Debug Builds

Debug-only bypasses must:
- be impossible or clearly segregated from production
- never appear in release builds
- never weaken safety testing

---

# 10. Updates

Application updates must preserve:
- commitment state
- whitelist
- policy state
- safety/recovery paths

Before migrations:
- validate local data
- keep rollback-safe schema versions

---

# 11. Security Principle

The product must not become a surveillance layer in the process of becoming a distraction-control layer.
