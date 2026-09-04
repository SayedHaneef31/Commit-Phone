# 09 — Permissions, Roles and Capabilities

## Purpose
Central registry for every sensitive Android capability used by the product.

## Rules
- Ask only when necessary.
- Explain purpose before system prompt.
- Prefer normal APIs over powerful special access.
- Document fallback if denied.
- Do not request everything during first launch.

---

# Capability Matrix

| Capability | Purpose | Timing | User choice | Fallback |
|---|---|---|---|---|
| HOME role | Launcher | Early | Required for full experience | Device default launcher |
| Notifications | Filtering | Trial/commitment | Optional until needed | No filtering |
| Contacts | Contacts | When feature used | User permission | System contacts app |
| Phone | Calls | When feature used | Platform-dependent | Native dialer |
| SMS | Messaging | When feature used | Platform/default-role dependent | Native SMS app |
| Accessibility | Strong restrictions if required | Strong commitment | Explicit | Lighter mode |
| Device management | Hardcore enforcement | Strong commitment | Explicit | Non-managed commitment |
| Input method | Future T9 | Future | Optional | Normal keyboard |
| Location | Maps-related handoff | As needed | App handles | Native app prompt |

---

# Permission UX

For each sensitive permission, the app should communicate:

1. What it enables.
2. Why the product needs it.
3. Whether the feature works without it.
4. What happens if it is denied.
5. How to revoke it later.

---

# Sensitive Permission Policy

Never:
- request access without a corresponding implemented feature
- use accessibility as an undocumented control channel
- read private content unless the feature explicitly requires it
- store permission-derived data unnecessarily

---

# Strong Commitment Permission Flow

```text
User completed trial
→ chooses stronger commitment
→ permission explanation
→ user consent
→ system settings / role prompt
→ validate capability
→ enable corresponding feature
```

If the capability cannot be established:
- do not pretend it is active
- downgrade to the supported mode
- tell the user exactly what remains unavailable

---

# Capability Verification

After the user grants access, run a small validation check.

Example:
- notification access granted → confirm listener is active
- device-management setup completed → confirm expected policy state
- HOME role active → confirm launcher role

Never assume a permission grant equals full feature availability.
