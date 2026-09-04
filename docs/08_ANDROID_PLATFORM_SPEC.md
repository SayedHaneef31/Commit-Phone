# 08 — Android Platform Specification

## Purpose
Defines the Android mechanisms the product may rely on and the limitations that must be validated during implementation.

> This document is a planning reference. Android behavior varies by version/OEM. Platform-sensitive claims must be verified against the actual target SDK and test devices before being treated as guaranteed.

---

# 1. HOME Role / Launcher

Mechanism:
- Android HOME intent/category and appropriate launcher registration.

Expected capability:
- participate as a launcher/home application
- launch activities/apps
- receive home navigation when selected as default

Constraint:
- being a launcher does not automatically grant device-management authority.

---

# 2. App Discovery

Candidate mechanisms:
- PackageManager
- LauncherApps
- intent resolution

Use the most launcher-appropriate API available for the target Android versions.

Need to account for:
- work/profile apps
- disabled packages
- multiple activities
- package updates
- uninstall/install changes

---

# 3. Launching Apps

Use Android-supported launch intents/activity launch mechanisms.

Never assume every installed package exposes a launchable activity.

---

# 4. Device Management

Candidate:
- DevicePolicyManager / managed-device APIs

Important:
- stronger device-management behavior can require device-owner/profile-owner provisioning or specific managed-device states
- normal launcher installation does not automatically make the launcher device owner
- provisioning strategy must be designed and validated separately

---

# 5. Accessibility

AccessibilityService is a sensitive capability.

It should only be used when:
- a real product requirement needs it
- Android-supported behavior cannot be achieved through a safer API

Do not use accessibility merely as a generic "do everything" mechanism.

---

# 6. Notification Access

Candidate:
- NotificationListenerService

Use for:
- filtering
- presentation
- notification-aware product behavior

Constraints:
- user-granted special access
- privacy-sensitive
- must be clearly explained

---

# 7. Default Application Roles

Some functions have platform-defined default-role behavior, such as:
- browser
- dialer
- SMS

The launcher should not assume it can replace these experiences merely by being HOME.

Role-specific requirements must be evaluated independently.

---

# 8. Telecom / Calls

Candidate:
- Telecom framework
- RoleManager/default dialer mechanisms where necessary

Important:
- normal phone calling can remain available without making the launcher a full replacement dialer
- becoming default dialer introduces additional requirements and platform behavior that must be validated

---

# 9. SMS/MMS

SMS functionality may be subject to default SMS app/role rules and permissions.

The implementation should not assume a launcher can fully manage SMS while another app remains the default handler.

---

# 10. Contacts

Candidate:
- Contacts Provider/content resolver mechanisms

Prefer system-backed data over unnecessary duplication.

---

# 11. Camera

The preferred MVP is to launch the device's camera application or supported camera intent.

Do not build a custom camera until product value justifies it.

---

# 12. Storage / Files

Modern Android storage is scoped and permission behavior differs by media/file type and Android version.

Use:
- Storage Access Framework where appropriate
- MediaStore where appropriate
- app-private storage for launcher data

Avoid broad storage access unless a concrete use case requires it.

---

# 13. Widgets

Future:
- AppWidgetManager
- widget-host mechanisms

Not required for MVP.

---

# 14. Input Method

Future:
- InputMethodService

A custom T9 IME can eventually extend keypad interaction beyond the launcher into text input.

---

# 15. Network Control

The product should not depend on artificial 3G/4G throttling.

Any future traffic/domain filtering requires separate technical/legal evaluation.

A launcher alone does not become a universal network firewall merely because it is HOME.

Potential future mechanisms may involve a VPN-based local filter, but this must be assessed independently.

---

# 16. System Settings

The launcher may deep-link to supported system settings.

It should not assume it can programmatically change every system setting.

Certain sensitive changes require user/system UI.

---

# 17. Lock Screen

A third-party launcher is not equivalent to a replacement for the platform lock screen.

The project should treat the device's actual lock screen as platform-controlled unless a supported mechanism says otherwise.

The product can provide lock-screen-adjacent behavior only within supported limits.

---

# 18. Power / Battery

The launcher should avoid unnecessary background services and wakeups.

Battery optimization behavior varies by OEM.

---

# 19. OEM Differences

Test at minimum across representative devices rather than relying on one phone.

Areas likely to differ:
- default launcher behavior
- permissions
- battery management
- package visibility
- role handling
- device-management provisioning
- notification behavior

---

# 20. Platform Feasibility Labels

Every technical feature should eventually receive one of:

🟢 Supported through normal APIs  
🟡 Supported with special permission/role  
🟠 Requires managed-device/device-owner style provisioning  
🔴 Not realistically available to a normal third-party application

No feature should be marked green without implementation validation.
