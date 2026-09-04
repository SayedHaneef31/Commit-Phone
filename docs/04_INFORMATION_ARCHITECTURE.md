# 04 — Information Architecture

## Purpose
Defines what exists in the product and how it is organized.

## Top-Level Model

```text
PHONE
├── Home
├── Menu
│   ├── Phone
│   ├── Contacts
│   ├── Messages
│   ├── Camera
│   ├── Gallery
│   ├── Clock
│   ├── Calendar
│   ├── Calculator
│   ├── Notes
│   ├── Files
│   ├── Weather
│   ├── QR Scanner
│   ├── Connectivity
│   ├── Email
│   ├── Browser
│   ├── Approved Tools
│   └── Settings
└── Notification Center
```

## Home

Home contains:
- status
- time/date
- D-pad
- keypad
- soft-key actions

Home must not become a dashboard.

## Menu

Initial structure is intentionally linear. Categories can be introduced later only when the application count materially justifies them.

## Approved Tools

Contains only policy-approved modern applications.

No open-ended app drawer.

## Settings

```text
Settings
├── Sound
├── Display
├── Connectivity
├── Phone
├── Apps
├── Date & Time
├── Security
├── Commitment
├── Permissions
└── About
```

System settings may remain reachable through deliberate flows.

## Notification Center

A controlled list of relevant notifications. No social-style feed.

## Information Architecture Rules

1. Essential functions must be reachable in few steps.
2. Distractions must not appear in normal navigation.
3. App discovery should not feel like browsing a store.
4. D-pad navigation must remain coherent.
5. Deep configuration belongs in Settings, not Home.
6. Modern applications are tools, not the primary information architecture.
