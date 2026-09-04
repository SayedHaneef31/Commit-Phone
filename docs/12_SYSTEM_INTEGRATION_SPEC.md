# 12 — System Integration Specification

## Purpose
Defines integration with Android system functionality.

## Integration Strategy

MVP uses native/system functionality where reliable and appropriate.

The launcher should act as the orchestrator rather than rebuilding Android unnecessarily.

---

# Phone

Responsibilities:
- expose call entry
- preserve incoming-call functionality
- open call history/dialer where supported

Avoid replacing the system dialer unless needed.

---

# Contacts

Use system contacts data.

Desired interaction:
```text
Menu → Contacts → D-pad → contact → action
```

---

# Messaging

MVP may use the system/default SMS application.

Future custom messaging UI can be introduced after launcher stabilization.

---

# Camera

Launch the device camera.

Do not duplicate camera implementation in MVP.

---

# Gallery

Launch a suitable device photo/media experience.

---

# Clock

Use native clock/alarm capabilities initially.

---

# Calendar

Use existing calendar application/functionality initially.

---

# Calculator

Minimal implementation or native calculator depending on availability.

---

# Bluetooth

Provide a clear route to Android connectivity management.

---

# Wi-Fi

Provide a clear route to Android Wi-Fi controls.

---

# Hotspot

Preserve access through platform-supported mechanisms.

---

# Weather

Use a simple service or user-selected weather application only when product requirements justify network integration.

Avoid feed-style weather.

---

# QR

Provide a practical scanning entry point.

---

# Email

Launch user's preferred email application.

---

# Browser

Expose browser only through deliberate navigation.

---

# System Settings

Expose selected system settings through supported Intent actions.

Never assume every settings page exists on every OEM.

---

# Emergency and Safety

Do not intercept or break emergency system behavior.

---

# App Return

Every external app launch should have:
- clear entry
- expected return
- focus restoration
- error handling if activity unavailable

---

# Future Custom Utilities

Candidate custom replacements:
- Contacts
- Messages
- Clock
- Calendar
- Gallery

Priority depends on whether native experiences meaningfully undermine the keypad-phone mental model.
