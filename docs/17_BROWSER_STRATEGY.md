# 17 — Browser Strategy

## Product Goal

Keep the internet as a useful tool without allowing unrestricted web access to become a replacement route back into the smartphone lifestyle.

## MVP

- Browser remains accessible.
- Browser is not placed as a prominent Home item.
- No news/recommendation feed is added by the launcher.
- User can access normal web services.

## Problem

A browser is effectively an escape hatch:
```text
Browser
→ search
→ social media
→ video
→ feeds
→ distraction
```

This cannot be solved reliably by hiding Chrome alone.

---

# V1/V2 Direction

Investigate a controlled browser strategy.

Possible approaches:
1. dedicated simple browser
2. browser wrapper around supported web content
3. domain/category filtering
4. local VPN/network policy where appropriate
5. curated search/result experience

Each option has trade-offs.

---

# Principles

Do not:
- intentionally degrade network speed
- block general internet by default
- pretend that a hidden browser solves the problem

Prefer:
- deliberate access
- clear policy
- minimal UI
- predictable behavior

---

# Open Technical Questions

- Can a controlled browser provide enough compatibility?
- How can domains be blocked without becoming a full security product?
- How should HTTPS and certificate behavior be handled?
- How does Play Store policy affect filtering approaches?
- Is VPN-based filtering appropriate for the product?

These require platform/policy validation before implementation.

---

# MVP Acceptance

The browser must not become a primary Home-screen engagement surface.
