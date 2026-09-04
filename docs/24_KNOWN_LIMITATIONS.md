# 24 — Known Limitations

## Purpose
Record platform/product limitations so agents do not repeatedly attempt impossible behavior.

## KL-001 — Launcher Authority

Being the default launcher does not automatically grant device-owner privileges or universal control over Android.

## KL-002 — Third-Party UI

The launcher cannot arbitrarily redraw or inject controls into another application's UI.

## KL-003 — App Uninstallation

An ordinary third-party launcher should not assume silent bulk uninstallation of arbitrary apps.

Supported user-confirmed or managed-device mechanisms must be used.

## KL-004 — System Settings

The launcher cannot assume it can programmatically alter every sensitive Android setting.

## KL-005 — Lock Screen

The launcher is not automatically a replacement for the platform's actual lock screen.

## KL-006 — Default App Roles

Dialer, SMS, browser, and other role-specific capabilities can have platform-specific requirements.

## KL-007 — Device Management

The strongest app/device restrictions may require managed-device provisioning.

## KL-008 — OEM Variation

Android OEMs can modify behavior, especially around permissions, background processing, launchers, and device management.

## KL-009 — Third-Party Apps Remain Third-Party

Allowed apps may still contain distracting features that the launcher cannot selectively remove.

## KL-010 — Browser Escape Risk

A general-purpose browser can undermine distraction controls unless a dedicated strategy is implemented.

## KL-011 — Custom Keypad Inside Apps

A launcher cannot simply place its own keypad UI inside arbitrary apps. A future IME is the more appropriate mechanism for broader text-entry control.

## KL-012 — Full "Dumbphone" Equivalence

Absolute replication of every physical keypad-phone behavior may not be possible without deeper system integration or custom hardware.

## Rule

When a limitation blocks a requirement:
1. confirm platform behavior
2. identify supported alternatives
3. update this document
4. record a decision
5. adjust the implementation plan
