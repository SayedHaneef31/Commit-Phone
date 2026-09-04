# 16 — Notification Specification

## Goal

Notifications should communicate genuinely important events without recreating the smartphone notification environment.

## MVP Policy

### Preserve
- calls
- direct messages
- authentication/security events
- banking/payment alerts
- work-critical notifications
- emergency/system notifications

### Restrict
- social engagement
- entertainment
- promotional
- recommendation
- low-value notifications

---

# 1. Notification Center

The product-owned notification view should be:
- list-based
- finite
- non-feed-like
- no infinite scrolling
- no badges

---

# 2. Notification Batching

Future.

Possible model:
```text
Important now
Messages
Work
Later
```

---

# 3. Sound

Essential notifications may use normal sounds.

No product feature should add unnecessary notification sounds.

---

# 4. Vibration

Preserve useful haptics according to user preferences.

---

# 5. Badges

Not supported as a product pattern.

---

# 6. Notification Access

If notification access is used:
- explain it
- minimize processing
- avoid persistent storage
- disable the feature gracefully when access is revoked

---

# 7. Emergency

Emergency/system notifications have higher priority and are not subject to ordinary distraction filtering.

---

# 8. Future

Potential enhancements:
- scheduled summaries
- "important only" mode
- notification quiet periods
- communication priority
