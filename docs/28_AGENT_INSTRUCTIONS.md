# 28 — AI Agent Instructions

## Mission

Build and improve the product according to the documented product vision, requirements, UX, design, and technical constraints.

The agent is an implementer and engineering partner, not an autonomous product owner.

---

# 1. Read Before Acting

Before modifying code:
1. read `00_PRODUCT_VISION.md`
2. read `01_PRODUCT_PRINCIPLES.md`
3. read `02_PRODUCT_REQUIREMENTS.md`
4. read the relevant feature/design/technical document
5. read `27_PROJECT_STATE.md`

For Android-sensitive work, also read:
- `08_ANDROID_PLATFORM_SPEC.md`
- `09_PERMISSIONS_ROLES_AND_CAPABILITIES.md`
- `24_KNOWN_LIMITATIONS.md`

---

# 2. Authority Hierarchy

When documents conflict:

```text
Product Vision
→ Product Principles
→ Product Requirements
→ UX / Design / Feature Specs
→ Technical Architecture
→ Implementation Details
```

Platform reality overrides unsupported assumptions.

---

# 3. Do Not Invent Product Decisions

If a requirement is marked undecided/TBD:
- identify it
- propose options
- do not silently create a permanent product rule

A temporary implementation decision must be documented.

---

# 4. Do Not Invent Android Capabilities

Never assume:
- launcher = device owner
- launcher = dialer
- launcher = SMS app
- launcher can silently uninstall any app
- launcher can modify another app's UI
- launcher can override the lock screen
- launcher can bypass Android security

Validate the relevant platform mechanism.

---

# 5. Preserve Product Philosophy

Do not weaken the core product merely because a weaker implementation is easier.

The product is a commitment system.

Do not transform it into:
- a generic launcher
- a cosmetic minimalist launcher
- an unrestricted app drawer

---

# 6. Respect MVP Scope

Do not implement future roadmap items unless the active task explicitly includes them.

Especially avoid prematurely building:
- backend
- accounts
- themes
- advanced analytics
- custom browser
- hardware
- full app replacements

---

# 7. Minimize Dependencies

Before adding a library:
- verify native/AndroidX option
- assess size
- assess maintenance
- assess security/privacy
- document meaningful architectural decisions

---

# 8. Privacy

Never log or persist sensitive information unnecessarily.

Do not log:
- OTP/auth codes
- banking information
- message contents
- notification contents
- accountability PIN

---

# 9. Security

Do not create hidden production bypasses.

Any development bypass must be:
- debug-only
- clearly identified
- excluded from production builds

---

# 10. Testing

Do not declare a feature complete because it compiles.

For each feature:
- test happy path
- test failure path
- test lifecycle
- test permission denial where relevant
- test process restart
- test return from external app where relevant

---

# 11. Documentation Synchronization

When behavior changes:
- update relevant spec
- update project state
- update changelog if externally meaningful

When architecture changes:
- update technical architecture
- create a decision-log entry

When an Android limitation is discovered:
- update Android platform document
- update known limitations
- record the product impact

---

# 12. Architecture

Keep UI, domain policy, and Android platform concerns separated.

Do not put:
- commitment rules in Compose UI
- app classification inside a button handler
- device-management logic directly in screens

---

# 13. UX

Always preserve:
- keypad-first interaction
- D-pad navigation
- touch fallback when genuinely needed
- safe emergency access
- clear commitment messaging

---

# 14. Error Handling

Never silently fail.

For unsupported operations:
- show a clear explanation
- provide a supported fallback
- record platform limitation when appropriate

---

# 15. Compatibility

Do not assume one device proves Android compatibility.

Use compatibility matrix for:
- device differences
- OEM differences
- Android versions
- permission behavior

---

# 16. Product Quality

Prefer:
- simple
- reliable
- understandable
- low-distraction
- lightweight

over:
- feature-rich
- flashy
- clever
- highly configurable

---

# 17. Agent Output Standard

When reporting completed work, provide:
- what changed
- files changed
- tests run
- known issues
- documentation updated
- next logical task

Do not claim unsupported success.

---

# 18. Mandatory Stop Conditions

Pause and request a human decision when:
- two approved requirements conflict
- an implementation would violate a product principle
- Android does not support the requested behavior as assumed
- a security/privacy trade-off is materially different from documented policy
- a change could invalidate existing committed user state

Do not solve these silently.
