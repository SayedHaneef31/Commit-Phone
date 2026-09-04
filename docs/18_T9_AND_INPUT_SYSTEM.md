# 18 — T9 and Input System

## Purpose
Defines the long-term plan for extending the keypad interaction beyond the launcher.

## MVP

- numeric keypad
- numeric input
- normal Android keyboard fallback
- no requirement for complete T9

## V1 Direction

Implement T9 for product-owned text input where useful.

Example:
```text
43556
→ HELLO
```

Potential use:
- contact search
- app search if introduced
- notes
- messaging

---

# Future Input Method

A custom Android InputMethodService may provide a keypad-style IME.

Potential behavior:
- T9
- multi-tap
- numeric mode
- symbols
- predictive text
- D-pad cursor movement

---

# Third-Party Apps

The custom IME can potentially extend keypad input into:
- WhatsApp
- email
- work apps
- browser
- other text fields

But third-party apps remain responsible for their own UI.

---

# Product Rule

A normal keyboard remains available as fallback.

The goal is to reduce smartphone interaction, not to make essential typing impossible.
