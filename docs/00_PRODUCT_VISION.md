# 00 — Product Vision

## 1. Document Purpose

This document defines the foundational vision and identity of the product.

It is the highest-level product reference for the project. Product decisions, UX decisions, technical decisions, and implementation decisions must remain consistent with the principles defined here unless this document is explicitly revised.

This document describes **what the product is, why it exists, who it is for, and what it must never become**.

---

# 2. Product Definition

This product is an Android smartphone-to-keypad-phone transformation experience.

Its purpose is to take an existing modern Android smartphone and make it behave, look, and feel as much like a traditional keypad/dumb phone as reasonably possible while retaining a carefully controlled set of modern technologies that people genuinely need in everyday life.

The goal is **not** to create another minimalist launcher.

The goal is **not** merely to make Android look simpler.

The goal is:

> **Turn a smartphone into a real keypad phone while retaining only the technology the user genuinely needs.**

The phone should stop behaving like an entertainment device and return to being primarily a tool.

---

# 3. Core Philosophy

## 3.1 The launcher is a commitment system

The launcher is not a democratic app chooser where the user can freely add anything they want and still claim to have reduced distractions.

The user deliberately chooses to adopt this experience because they want to leave the smartphone lifestyle behind.

Therefore:

> **The launcher is not a democratic app chooser. It is a commitment system.**

Once the user commits, the system should protect that commitment through deliberate friction, restrictions, and controlled access.

---

## 3.2 Capability without compulsion

The product does not exist to make the phone incapable.

It exists to make the phone **intentional**.

The user should still be able to:

- call people
- message people
- navigate
- make payments
- authenticate for work
- use banking applications
- use essential communication tools
- take photographs and videos
- access other genuinely necessary tools

But the phone should stop continuously presenting:

- social feeds
- entertainment
- infinite scrolling
- games
- recommendation systems
- unnecessary notifications
- app-store wandering
- other mechanisms designed to capture attention

The philosophy is:

> **Keep capability. Remove compulsion.**

---

# 4. Problem Statement

Modern smartphones combine essential utilities with highly optimized attention-capture systems.

Many people want to switch to a dumb phone because they are dissatisfied with:

- excessive screen time
- doomscrolling
- social media consumption
- short-form video
- games
- constant notifications
- habitual phone checking
- loss of concentration
- the feeling that their phone controls their behavior

However, traditional dumb phones create a different problem.

Modern life often requires tools that classic dumb phones cannot provide.

Examples include:

- authentication applications
- navigation applications
- UPI/payment applications
- banking applications
- work applications
- modern messaging applications
- QR-based services
- occasional web access
- other essential digital services

This creates a gap between:

**Modern smartphone**

> highly capable, highly distracting

and:

**Traditional dumb phone**

> highly focused, but often too limited for modern life

This product exists to occupy that gap.

---

# 5. Product Opportunity

The product creates a third category:

## A modern dumb phone built on smartphone hardware.

The underlying Android device remains capable.

The user's experience does not.

The phone intentionally exposes only the functionality that serves the user's life.

Conceptually:

```text
Traditional Dumb Phone
    ↓
Low distraction
    ↓
Too little modern functionality


Modern Smartphone
    ↓
Maximum functionality
    ↓
Maximum distraction


This Product
    ↓
Keypad-phone experience
    +
Necessary modern tools
    -
Unnecessary smartphone experience
```

The ideal outcome is:

> **A modern Android phone that feels like a very capable keypad phone rather than a restricted smartphone.**

---

# 6. Target Users

## Primary target

People who:

- genuinely want to switch to a dumb/keypad phone
- have already recognized that their smartphone usage is excessive
- are tired of doomscrolling or compulsive app usage
- want stronger intervention than a typical "minimal launcher"
- need a small number of modern apps for daily life or work
- are willing to give up most smartphone applications
- are willing to adopt deliberate friction
- want their phone to become a tool rather than a source of entertainment

Examples include people who cannot move to a physical dumb phone because they need:

- Microsoft Authenticator
- Duo
- Google Maps
- UPI applications
- banking applications
- WhatsApp
- work applications
- other legitimate utility software

---

# 7. Non-Target Users

The product is intentionally not designed for users who are primarily looking for:

- another customizable Android launcher
- a visually minimal home screen while keeping all smartphone habits
- easy access to social media
- an entertainment-focused phone with a minimal appearance
- unrestricted app installation
- unrestricted browsing
- extensive launcher customization

A person should not be able to install the product, keep all of their distracting applications, and continue using the phone in essentially the same way while calling the experience "dumbphone mode."

That would violate the purpose of the product.

---

# 8. Core User Promise

The product should be able to truthfully tell the user:

> **You can keep the smartphone technology you genuinely need without keeping the smartphone lifestyle you are trying to escape.**

The user should feel that:

- the phone belongs to them
- the phone is under their control
- the phone is useful
- the phone is intentionally boring when there is nothing important to do
- the phone does not constantly ask for attention
- opening the phone is not automatically the start of an entertainment session

---

# 9. What Success Looks Like

After using the product for an extended period, the user should be able to say:

> "My phone no longer uses me. I use my phone."

A successful user should experience:

- significantly less compulsive phone use
- less doomscrolling
- less social-media consumption
- less habitual unlocking
- more focused time
- easier separation between tool usage and entertainment
- continued access to genuinely necessary technology
- the feeling that their smartphone has effectively become a keypad phone

The ideal psychological state is:

```text
Need something
    ↓
Use phone
    ↓
Finish
    ↓
Put phone away
```

rather than:

```text
Bored
    ↓
Unlock phone
    ↓
Open feed
    ↓
Consume
    ↓
Scroll
    ↓
Scroll
    ↓
Lose time
```

---

# 10. Product Experience

The user's core daily experience should resemble a traditional keypad phone.

The phone should have:

- a keypad
- a directional pad
- soft-key style actions
- phone-like menus
- phone-like navigation
- phone-like lists
- phone-like feedback
- phone-like interaction patterns

The keypad is not decorative.

It is a functional input method.

The desired mental model is:

> **"I am using a keypad phone."**

not:

> **"I am using Android with a keypad-themed launcher."**

---

# 11. Smartphone Capabilities That Remain

The product deliberately retains legitimate modern functionality.

Examples include:

## Core phone capabilities

- Phone calls
- Contacts
- SMS/MMS
- Camera
- Gallery
- Clock
- Alarm
- Stopwatch
- Timer
- Calculator
- Calendar
- Notes
- Minimal file management
- Bluetooth
- Wi-Fi
- Hotspot
- Weather
- Flashlight
- QR scanning
- Email
- Limited browser capability

## User-specific essential tools

Examples may include:

- Google Maps
- Microsoft Authenticator
- Duo
- UPI applications
- Banking applications
- WhatsApp
- legitimate work applications
- other essential utility applications

The exact user-specific application set is configurable, but it must remain consistent with the product philosophy.

---

# 12. Applications That Should Not Become Part of the Experience

The product should strongly reject applications whose primary role is:

- social media
- entertainment
- gaming
- infinite-feed consumption
- short-form video
- attention capture
- recreational browsing

Examples may include:

- Instagram
- TikTok
- entertainment video applications
- social networks
- games
- other known high-distraction applications

The purpose is not to maintain an arbitrary blacklist forever.

The product should eventually use an intelligent application policy system that evaluates the nature and purpose of an application.

The guiding question is:

> **Is this application a tool the user genuinely needs, or is it primarily a source of consumption and distraction?**

---

# 13. Essential Applications vs. Distraction Applications

Applications should conceptually fall into policy categories.

Initial categories:

```text
CORE
Essential functionality provided by the phone experience.

ESSENTIAL TOOL
A legitimate application required for the user's work or daily life.

REVIEW
An ambiguous application whose purpose requires evaluation.

TEMPORARY
An application that may be needed occasionally but should not
be permanently available.

DISALLOWED
An application whose primary purpose conflicts with the product.

```

The system should not treat all third-party applications equally.

---

# 14. User Commitment

The product intentionally requires commitment.

The onboarding experience should explain clearly:

- what is going to change
- which applications may be removed or restricted
- why permissions may eventually be required
- why the product introduces friction
- how the keypad experience works
- how the user can access essential tools
- how emergency recovery works

The user must understand that this is not simply a cosmetic launcher.

They are choosing to fundamentally change how they use their smartphone.

---

# 15. Trial Philosophy

The first experience should allow the user to understand the product before demanding the strongest device-level commitments.

The initial experience should:

1. Explain the philosophy.
2. Demonstrate the phone experience.
3. Allow the user to try the experience.
4. Gradually explain deeper permissions and restrictions.
5. Give the user an opportunity to make an informed commitment.

The intended initial trial is approximately three days.

During the trial, the product may use strong friction while still preserving a technically recoverable path to the normal Android experience.

After the trial, the user can choose whether to continue and whether to enable stronger enforcement.

---

# 16. Strong Commitment Philosophy

Users who choose stronger commitment explicitly consent to deeper enforcement mechanisms.

This may eventually include:

- stronger app restrictions
- stronger launcher protection
- restricted access to distraction applications
- configuration locking
- deliberately difficult exit procedures
- accountability mechanisms
- Android device-management capabilities where technically and legally appropriate

The strongest mode should provide the closest possible approximation of:

> **"I have turned my smartphone into a dumb phone."**

---

# 17. Friction Philosophy

Friction is a feature, not a bug.

However, friction should serve a clear purpose.

Good friction:

- protects a commitment
- prevents impulsive changes
- forces intentionality
- slows access to distracting applications
- makes escape deliberate
- prevents accidental circumvention

Bad friction:

- makes legitimate essential tasks unnecessarily difficult
- blocks accessibility
- breaks banking or authentication workflows
- makes emergency functions unreliable
- frustrates users during normal phone usage

Core principle:

> **Friction should defend the user's intention, not punish the user's legitimate needs.**

---

# 18. Accountability Philosophy

A local accountability mechanism is intended for the first version.

The user should be encouraged to have another trusted person create the commitment/accountability PIN instead of creating a PIN they personally know.

The purpose is psychological, not cryptographic:

> The user should not be able to impulsively undo their own commitment.

A future version may support account-based accountability and remote approval, but backend/account functionality is explicitly outside the initial product scope.

---

# 19. Browser Philosophy

The product should not attempt to disconnect users from the internet.

Internet access is a legitimate modern utility.

However, the browser must not become an obvious escape route back into the smartphone experience.

The long-term goal is a controlled browsing experience where:

- useful information remains accessible
- work and service websites remain accessible
- necessary internet functionality remains available
- known distraction destinations can be restricted
- infinite-feed and entertainment behavior can be reduced

The MVP should avoid building a complete custom browser unless necessary.

---

# 20. Native vs. Custom Experiences

The project should be built incrementally.

The initial version should not attempt to recreate every Android application.

The first priority is the **phone shell and commitment experience**.

The MVP may therefore use native Android/system applications for many functions, including:

- Camera
- Gallery
- Maps
- Banking
- Authentication
- WhatsApp
- other essential third-party applications

The launcher itself should provide the keypad-phone experience.

Over time, selected system experiences may be replaced with custom minimal implementations.

This follows the strategy:

> **Build the shell first. Replace individual experiences progressively.**

---

# 21. Interaction Philosophy

The interaction hierarchy should be:

```text
D-pad / Keypad
        ↓
Primary interaction

Touch
        ↓
Secondary interaction where D-pad interaction
is impractical or inefficient

Native full-screen application interaction
        ↓
Used when a legitimate third-party/system application
requires richer interaction
```

The product should strive toward keypad-first usage rather than merely displaying a keypad.

A future custom T9 input method may extend keypad interaction into third-party applications.

---

# 22. Visual Philosophy

The visual language should resemble a real keypad phone while still feeling thoughtfully designed.

Desired characteristics:

```text
Retro feeling:        High
Visual distraction:   Very low
Visual character:     Moderate
Aesthetic quality:    High
Complexity:           Low
```

The initial theme is:

- Black
- Simple
- Phone-like
- Modern-retro
- Functional
- Lightweight

The product should not feel like:

- a generic minimalist launcher
- an accessibility UI
- a terminal-themed novelty application
- an intentionally ugly "digital detox" interface

It should feel like:

> **A premium keypad phone from an alternate version of 2026.**

---

# 23. Lightweight Philosophy

The launcher must remain lightweight.

It should work across a broad range of Android devices rather than being designed only around a single manufacturer's hardware.

The project is initially optimized for modern mainstream Android devices while accepting that a small percentage of older or unusual devices may not support every advanced capability.

The product should avoid unnecessary:

- background work
- heavy graphics
- large dependencies
- cloud infrastructure
- analytics
- services unrelated to the core experience

---

# 24. Privacy Philosophy

Trust is fundamental.

The product potentially interacts with sensitive system functionality and therefore must not behave like the attention-capture applications it is replacing.

The default philosophy should be:

> **Collect as little data as necessary.**

Core functionality should initially work without:

- an account
- a backend
- cloud synchronization

Any future analytics, cloud functionality, or accountability infrastructure must be justified explicitly and documented.

Permissions should always have:

- a clear purpose
- a clear explanation
- appropriate timing
- a defined fallback if denied

The product should never request sensitive permissions merely because they are technically available.

---

# 25. Platform Philosophy

The product is an Android application and should use Android-native mechanisms whenever possible.

The initial technology direction is:

- Kotlin
- Jetpack Compose
- Android SDK
- Android launcher APIs
- Android system APIs
- Hilt
- DataStore
- Room where structured persistence is needed
- Gradle Kotlin DSL
- native Android testing tools

The product must respect Android's security model and platform limitations.

It must never assume that being the launcher automatically grants control over every part of Android.

---

# 26. Failure Philosophy

The phone must remain usable even when the launcher encounters problems.

If the launcher:

- crashes
- is disabled
- is uninstalled
- loses required permission
- encounters an unexpected Android state

the system should fail safely and provide a practical recovery route to the device's normal Android launcher wherever possible.

Emergency phone functionality must never be compromised.

---

# 27. Things This Product Must Never Become

The project must actively avoid becoming:

### Another minimal launcher

A launcher that looks clean but still leaves every addictive application one tap away.

### A restrictive novelty app

A gimmicky keypad skin without meaningful behavioral change.

### A paternalistic phone

A system that unnecessarily blocks legitimate tools or treats users as incapable of making decisions.

### A surveillance product

A system that collects excessive usage, browsing, communication, or behavioral data.

### A complicated productivity platform

The product should not replace one form of digital distraction with dashboards, badges, goals, streaks, points, or excessive configuration.

### A smartphone disguised as a dumb phone

If the user can easily return to endless feeds, entertainment, and unrestricted app discovery, the product has failed its fundamental purpose.

---

# 28. Core Product Principles

Every future decision should be evaluated against these principles:

## Principle 1 — Phone first

The primary experience is a phone, not an app platform.

## Principle 2 — Essential technology remains

The product must preserve modern tools that users genuinely need.

## Principle 3 — Distraction is deliberately removed

The product must not merely hide distractions cosmetically.

## Principle 4 — Keypad is functional

The keypad and D-pad must represent a real interaction model.

## Principle 5 — Commitment is protected

Users who choose commitment should receive meaningful protection from impulsive reversal.

## Principle 6 — Legitimate needs come first

Necessary work, safety, communication, navigation, banking, authentication, and other legitimate functions should not be unnecessarily broken.

## Principle 7 — Friction protects intent

Friction exists to protect the user's decision, not to create arbitrary inconvenience.

## Principle 8 — Privacy builds trust

The product should minimize data collection and explain sensitive permissions clearly.

## Principle 9 — Simplicity wins

The phone should feel straightforward enough that a user can understand it without a manual.

## Principle 10 — The phone is a tool

The user's phone should serve their life, not become the center of it.

---

# 29. Ultimate Product Test

A successful implementation should pass this test:

> **If someone uses the product for six months, can they genuinely say that their smartphone feels like a keypad phone, while still being able to complete the essential tasks that prevented them from buying a dumb phone in the first place?**

If the answer is no, the product has not achieved its purpose.

---

# 30. Current Product Definition

At the current stage, the product can be summarized as:

> **A lightweight Android experience that transforms a modern smartphone into a keypad/dumb phone, preserves genuinely necessary modern tools, removes or restricts addictive smartphone applications, and uses deliberate commitment mechanisms to help the user maintain control over their attention.**

The desired end state is not:

> "I have a minimalist phone."

It is:

> **"I have a phone again."**
