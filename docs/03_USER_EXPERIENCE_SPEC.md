# 03 — User Experience Specification

## Purpose
Defines the end-to-end experience from installation through daily use, commitment, recovery, and eventual exit.

## Core UX Principle
The user is knowingly changing a smartphone into a keypad phone. The experience must feel like a product transformation, not a launcher installation.

---

## 1. Primary User Journey

```text
Discover product
→ Install
→ First launch
→ Understand philosophy
→ Interactive preview
→ Start 3-day trial
→ Configure essential tools
→ Clean up distractions
→ Daily keypad-phone experience
→ Trial ends
→ Choose normal / committed / stronger mode
→ Continue using phone as a keypad phone
```

---

## 2. First Launch

### Goals
- Explain the product honestly.
- Establish trust.
- Demonstrate the experience before asking for deeper permissions.
- Make the consequences of commitment explicit.

### Screen sequence
1. Welcome
2. Why this exists
3. What changes
4. What remains
5. Interactive keypad demo
6. Modern-tool demo
7. Trial explanation
8. Permission explanation, only where immediately useful
9. Start trial

### Core message
> Your smartphone is capable of thousands of things. You probably only need a few. This turns it into a phone again.

---

## 3. Interactive Preview

The user should be able to explore a simulated version of:
- Home
- D-pad
- Keypad
- Menu
- Contacts
- Call flow
- Modern tools
- Return-to-phone behavior
- Commitment concept

The preview must not accidentally modify the device.

---

## 4. Three-Day Trial

### Intent
Allow the user to experience the behavioral change before stronger commitment.

### Trial characteristics
- Keypad UI active.
- D-pad-first navigation active.
- Distraction apps are hidden from the launcher.
- Strong friction is present.
- Full device-management enforcement is not required during the initial trial.
- Recovery remains technically possible.

### Trial messaging
Do not use manipulative scarcity language.

Use clear language:
> You are trying a different way of using your phone. Nothing is permanently locked yet.

---

## 5. Essential App Setup

After entering the trial, show core applications separately from user-specific applications.

### Core
Phone, Contacts, Messages, Camera, Gallery, Clock, Calendar, Calculator, Notes, Files, Connectivity, Weather, QR, Email, Browser.

### User-specific
Ask which modern tools are genuinely needed:
- Maps
- Authenticator
- Duo
- UPI
- Banking
- WhatsApp
- Work apps
- Other legitimate utilities

Each requested app enters the policy evaluation process.

---

## 6. Distraction Cleanup

The user should first see the high-impact cleanup set.

Example:
> We found 14 applications that conflict strongly with the phone you chose.

Prefer an assisted cleanup flow over asking the user to hunt through Android settings.

Where silent/bulk uninstallation is not available to an ordinary app, launch the supported Android uninstall flow and keep the launcher useful while cleanup continues.

Unremoved disallowed apps may remain hidden/restricted subject to platform capability.

---

## 7. Daily Home

The default screen should be intentionally calm.

Core elements:
- time
- date
- device status
- keypad
- D-pad
- soft-key actions

No:
- app grid
- news
- social feed
- recommendation feed
- notification badges
- engagement metrics

---

## 8. Opening a Core Function

Example:

```text
Home
→ Menu
→ Contacts
→ D-pad to person
→ OK
→ Call
```

The product should make the normal path possible without touch.

---

## 9. Opening a Modern Tool

Example:

```text
Home
→ Menu
→ Maps
→ OK
→ Maps opens
→ Complete task
→ Back/Home
→ Keypad phone returns
```

For apps requiring full-screen interaction, keypad UI may disappear temporarily.

---

## 10. WhatsApp / Modern App Experience

MVP:
- Open the installed application normally.
- Do not attempt to rewrite its internal UI.
- Allow normal keyboard input if required.
- Return cleanly to the launcher.

Long-term:
- custom T9 input method may reduce the gap between third-party applications and the keypad experience.

---

## 11. Notifications

Default model:
- no badges
- filter distraction notifications
- preserve essential notifications
- allow batching
- preserve important sounds/vibration according to user settings

Notification access should be explained clearly before it is requested.

---

## 12. Trial Completion

At approximately three days, show:

> You have now lived with Phone Mode for three days.

Choices:
1. Continue with lighter commitment.
2. Enable strong commitment.
3. Return to normal Android.

The strongest option must explain required permissions and device-management implications before activation.

---

## 13. Strong Commitment Setup

Sequence:
1. Explain exactly what will be restricted.
2. Review essential apps.
3. Review apps that will be denied.
4. Explain required permissions.
5. Ask explicit consent.
6. Configure accountability.
7. Configure protection interval.
8. Confirm.
9. Enter keypad-phone mode.

---

## 14. Accountability Setup

The user is encouraged to ask another person to create the accountability PIN.

Recommended UX:
> Give this device to someone you trust. Ask them to create the commitment PIN. Do not choose a PIN you already know.

No account is required in V1.

---

## 15. Changing Commitment

Protected action flow:
```text
Settings
→ Commitment
→ Change commitment
→ Explain consequences
→ Delay / deliberate friction
→ Accountability PIN if required
→ Final confirmation
→ Apply
```

The exact controls depend on active commitment mode.

---

## 16. Attempting to Open a Disallowed App

The default response should be concise and non-judgmental.

Example:
> This app is outside the purpose of your Phone Mode commitment.

Possible actions:
- Back
- Learn why
- Request temporary access where supported

No shame language.

---

## 17. Temporary Access

Future flow:
```text
Disallowed/temporary app
→ Request access
→ Wait/schedule
→ Session starts
→ Countdown
→ Session ends
→ Access revoked/restricted
```

This is not required for MVP unless the implementation proves low-risk and simple.

---

## 18. Emergency Exit

Emergency exit must remain available.

Possible triggers:
- critical system problem
- launcher failure
- device-management recovery
- user-selected emergency recovery path

The emergency path should be reliable rather than intentionally confusing.

---

## 19. Normal Exit

Normal exit should be:
- easy in trial
- deliberate in committed mode
- strongly protected in hardcore mode, subject to Android capabilities

The product must never promise a stronger lock than Android can actually enforce.

---

## 20. Returning From Apps

When returning to the launcher:
- restore correct focus
- restore keypad/D-pad state
- do not reopen an old modal unexpectedly
- preserve the user's position when appropriate

---

## 21. Failure UX

Examples:
- missing permission → explain impact + recovery
- missing essential app → identify it clearly
- unsupported feature → explain limitation rather than silently failing
- launcher crash → rely on safe Android recovery and normal launcher fallback where available

---

## 22. UX Success Criteria

A new user should be able to:
- understand the concept without technical knowledge
- complete setup within approximately 5–10 minutes excluding optional cleanup
- make phone calls
- message
- use essential tools
- navigate the launcher with keypad/D-pad
- understand how to recover
- understand that commitment is intentional
