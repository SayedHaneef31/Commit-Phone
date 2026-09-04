# 01 — Product Principles

## 1. Purpose

This document defines the rules that govern product, UX, design, architecture, and implementation decisions.

`00_PRODUCT_VISION.md` defines **what the product is**.

This document defines **how decisions should be made while building it**.

When a new feature, design choice, technical shortcut, or business idea is proposed, it should be evaluated against these principles.

A feature that technically works but violates these principles should not be accepted without an explicit product decision.

---

# 2. The Core Principle

## The phone belongs to the user.

The product exists to restore a healthy relationship between a person and their phone.

The phone should serve the user.

The user should not feel that the phone, applications, feeds, notifications, or recommendation systems are directing their behavior.

The desired relationship is:

```text
USER
  ↓
uses
  ↓
PHONE
  ↓
provides
  ↓
NECESSARY TOOLS
```

Not:

```text
APPS
  ↓
capture
  ↓
USER ATTENTION
  ↓
shape
  ↓
PHONE USAGE
```

---

# 3. Principle 1 — Phone First

The product must feel like a phone before it feels like an Android device.

The primary experience should revolve around:

- calling
- messaging
- contacts
- camera
- clock
- calendar
- practical utilities
- essential modern tools

The application ecosystem should be secondary.

The launcher must not feel like an app marketplace or app dashboard.

---

# 4. Principle 2 — Capability Without Compulsion

The product should preserve useful capabilities without preserving unnecessary mechanisms that encourage compulsive consumption.

A user should be able to retain:

- navigation
- authentication
- banking
- payments
- work applications
- legitimate communication
- other genuinely necessary tools

without needing to retain:

- social feeds
- entertainment ecosystems
- games
- infinite scrolling
- recommendation-driven consumption

The goal is not to make the phone weak.

The goal is to make the phone intentional.

---

# 5. Principle 3 — The Keypad Is Functional

The keypad must never become a decorative visual theme.

A keypad-phone experience means:

- the keypad has a functional purpose
- D-pad navigation is meaningful
- menus behave like phone menus
- number keys have useful behavior
- text entry should progressively support keypad-style interaction
- soft-key concepts should be meaningful
- navigation should be possible without constantly touching the screen

The product should continuously move toward:

> **A real keypad phone implemented on a touchscreen Android device.**

---

# 6. Principle 4 — D-Pad First

The interaction hierarchy should prioritize:

```text
1. D-pad / directional navigation
2. Numeric keypad
3. Physical/input-device controls when available
4. Touch
```

Touch remains important where it is genuinely superior or required.

For example:

- maps
- banking
- authentication
- complex third-party interfaces
- interfaces not designed around directional navigation

However, touch should not become the default simply because it is easier for the developer.

---

# 7. Principle 5 — The Simplest Successful Interaction Wins

When two implementations achieve the same practical goal, prefer the one requiring:

- fewer steps
- less cognitive load
- less visual complexity
- fewer decisions
- less configuration
- less screen interaction

The interface should feel obvious.

A user should not need to understand the application's architecture to use the phone.

---

# 8. Principle 6 — Friction Protects Commitment

Friction is intentional.

The product may deliberately slow or complicate:

- access to distractions
- disabling restrictions
- changing commitment settings
- adding questionable applications
- leaving strong commitment modes
- accessing temporary applications

But friction must have a reason.

Good friction:

```text
Impulse
  ↓
Pause
  ↓
Intentional decision
```

Bad friction:

```text
Simple legitimate task
  ↓
Unnecessary obstacle
  ↓
Frustration
```

The product should maximize the first and minimize the second.

---

# 9. Principle 7 — Essential Functions Must Remain Reliable

The product must not sacrifice critical real-world functionality in the pursuit of minimalism.

High-priority legitimate functions include:

- emergency calling
- normal phone calls
- messaging
- authentication
- banking
- UPI/payment operations
- navigation
- work applications
- necessary connectivity
- camera
- other explicitly approved essential utilities

A user should never miss an important work action, payment, authentication event, or emergency function because the launcher introduced unnecessary restrictions.

---

# 10. Principle 8 — Emergency Functions Are Sacred

Emergency functionality is never subject to ordinary distraction restrictions.

Examples include:

- emergency calls
- emergency system functionality
- required safety functionality

No product feature should make emergency access unreliable.

When a design conflict exists:

> Safety wins.

---

# 11. Principle 9 — The User Must Understand the Commitment

The product should never trick a person into granting powerful permissions or entering a restrictive mode without understanding what will happen.

Before significant changes, the product must explain:

- what is changing
- why it is changing
- what the user may lose
- what functionality remains
- what permissions are needed
- what can happen if permissions are denied
- how recovery works

The user should feel:

> "I knowingly chose this."

not:

> "The app trapped me."

---

# 12. Principle 10 — Strong Commitment Requires Explicit Consent

The strongest restrictions should never be silently enabled.

There should be a clear distinction between:

### Trial

The user is exploring the experience.

### Committed

The user knowingly chooses stronger protection.

### Hardcore

The user knowingly chooses the strongest available enforcement.

The user should explicitly opt into stronger capabilities and restrictions.

---

# 13. Principle 11 — Escape Must Exist, but It Need Not Be Convenient

The product should not create an unsafe or irrecoverable device state.

There must be an emergency or recovery path.

However, in strong commitment modes, leaving the experience should require deliberate action.

Conceptually:

```text
Normal use
   ↓
easy

Change commitment
   ↓
deliberate

Emergency recovery
   ↓
available

Impulsive escape
   ↓
difficult
```

The product should never depend on making the phone permanently inaccessible just to preserve commitment.

---

# 14. Principle 12 — Accountability Beats Self-Control When Appropriate

The product should recognize an important behavioral reality:

A person who is trying to escape compulsive use may also be the person most likely to undo the restriction during a moment of weakness.

Therefore, optional accountability mechanisms are valuable.

The first version may use a locally configured accountability PIN that is intentionally created by another trusted person.

The product should encourage the user not to know the PIN.

Future account-based accountability may be introduced later.

---

# 15. Principle 13 — Do Not Build Around Weak Willpower

The product should not assume:

> "The user can simply choose not to open Instagram."

Instead, the environment itself should support the user's chosen behavior.

The product should reduce:

- visual temptation
- app discoverability
- notifications
- easy access
- habitual pathways
- infinite content exposure

This is environmental design, not moral judgment.

---

# 16. Principle 14 — Do Not Treat All Apps Equally

An application should not automatically receive access simply because the user requests it.

The product should distinguish between:

```text
Essential utility
        ↓
Legitimate modern tool
        ↓
Ambiguous application
        ↓
Entertainment
        ↓
Social / addictive consumption
```

The closer an application is to legitimate utility, the lower the friction should be.

The closer it is to compulsive consumption, the stronger the restriction should be.

---

# 17. Principle 15 — Genuine Need Can Override General Rules Only Deliberately

There will always be edge cases.

For example, a workplace may require an application that looks unusual or has communication features that could be distracting.

The product should support deliberate review rather than blindly approving or denying every application based on simplistic rules.

The policy system should be conservative but not irrational.

A legitimate essential need should have a path to evaluation.

---

# 18. Principle 16 — The Product Must Be Opinionated

The product should have a strong point of view.

It should be willing to tell the user:

> "This application does not fit the phone you chose to build."

A product that allows every requested application eventually becomes a normal Android launcher with a different skin.

The product's value depends on having meaningful boundaries.

---

# 19. Principle 17 — The Product Must Not Become Paternalistic

Being opinionated does not mean pretending to own the user's device.

The user voluntarily enters the system.

The product protects the user's own stated intention.

Therefore:

- restrictions must be explained
- essential-use exceptions must be considered
- emergency recovery must exist
- strong modes must require consent
- the product should not secretly manipulate the user

The relationship is:

> **"You asked us to help protect the decision you made."**

Not:

> **"We know what is best for you."**

---

# 20. Principle 18 — Do Not Replace Smartphone Distractions With Launcher Distractions

The launcher itself must not become an attention-capture product.

Avoid unnecessary:

- badges
- streaks
- points
- leaderboards
- infinite feeds
- recommendation engines
- attention-grabbing animations
- excessive notifications
- gamification
- engagement loops

Even productivity features can become distractions.

Every feature must justify its existence.

---

# 21. Principle 19 — Boring Is Sometimes a Feature

The home screen should often have nothing interesting happening.

An ideal interaction may be:

```text
Unlock
  ↓
09:47
Wednesday
  ↓
No important activity
  ↓
Lock
```

That is not a failure.

It means the phone did not successfully lure the user into unnecessary consumption.

The product should not feel obligated to fill empty moments.

---

# 22. Principle 20 — Utility Over Novelty

A feature should not be added merely because it is technically interesting.

The question is:

> Does this help the person use the phone as a useful tool?

Examples of potentially useful features:

- navigation
- authentication
- banking
- messaging
- notes
- calendar
- camera
- alarms
- practical utilities

Examples that require strong scrutiny:

- feeds
- recommendations
- social discovery
- games
- entertainment hubs
- unnecessary customization
- engagement analytics

---

# 23. Principle 21 — Modern Apps Are Tools, Not the Environment

Third-party apps are sometimes necessary.

When they are necessary, the product should treat them as tools that the user enters intentionally.

The launcher should remain the stable environment.

Conceptually:

```text
KEYPAD PHONE
     ↓
Select Tool
     ↓
Modern Application
     ↓
Complete Task
     ↓
Return to Keypad Phone
```

The modern application should not redefine the entire phone experience.

---

# 24. Principle 22 — Do Not Rebuild Everything at Once

The project should evolve incrementally.

The initial priority is:

1. Launcher shell
2. Keypad/D-pad experience
3. App discovery
4. Application policy
5. Commitment system
6. Restrictions
7. System integration
8. Progressive replacement of selected native experiences

There is no value in spending months recreating every stock application before the core product works.

---

# 25. Principle 23 — Native First, Custom Where It Matters

Use existing Android capabilities when they are reliable and sufficient.

Build custom UI where it creates meaningful product value.

Initial strategy:

```text
Core launcher UI
→ custom

Keypad/D-pad
→ custom

Policy/commitment system
→ custom

Camera
→ native/phone camera

Banking
→ native application

Maps
→ native application

Authentication
→ native application

WhatsApp
→ native application
```

Over time:

```text
Native Contacts
      ↓
Custom minimal Contacts

Native Messages
      ↓
Custom minimal Messages

Native Clock
      ↓
Custom minimal Clock
```

---

# 26. Principle 24 — Design for Android, Not One Manufacturer

The product must not be designed around Samsung-specific behavior even though development may initially be tested on an S24 Ultra.

The target is Android broadly.

The architecture must account for:

- different OEMs
- different Android versions
- different system UIs
- different permission behavior
- different device capabilities
- different performance profiles

Samsung-specific functionality may be supported where appropriate, but it must never become a hidden architectural dependency.

---

# 27. Principle 25 — Lightweight by Default

The launcher should consume as little:

- CPU
- RAM
- battery
- storage
- background activity

as reasonably possible.

Avoid dependencies or services unless they solve a genuine problem.

The product should feel fast even on modest Android hardware.

---

# 28. Principle 26 — Privacy Is Part of the Product

The product is asking a user to trust it with powerful capabilities.

That trust must be earned.

Default direction:

```text
Local first
Minimal data
No unnecessary account
No unnecessary backend
No unnecessary telemetry
No unnecessary permissions
```

If a permission is requested, the product must be able to clearly answer:

> "Why does the phone transformation experience need this?"

---

# 29. Principle 27 — Never Collect Data Just Because We Can

Telemetry must have a legitimate purpose.

Before collecting data, ask:

1. Is it necessary?
2. Can the product function without it?
3. Can the same goal be achieved locally?
4. Is the user clearly informed?
5. Does the benefit justify the privacy cost?

If the answer is uncertain, do not collect it by default.

---

# 30. Principle 28 — Android Platform Reality Wins

Product vision does not override operating-system security.

If Android prevents a desired behavior:

Do not:

- invent an API
- claim unsupported behavior works
- bypass security controls
- build fragile hacks as though they were stable APIs

Instead:

1. document the limitation
2. determine the supported Android mechanism
3. evaluate alternatives
4. identify product impact
5. make an explicit decision

This project must work with Android rather than pretending Android behaves differently.

---

# 31. Principle 29 — Security Restrictions Should Be Deliberate

Powerful mechanisms such as:

- accessibility
- notification access
- device management
- default application roles
- input methods

must be treated as sensitive capabilities.

Use the minimum capability necessary for the current feature.

Do not request powerful access merely to simplify implementation.

---

# 32. Principle 30 — Permission Timing Matters

The product should not immediately bombard a new user with a long list of frightening permissions.

The onboarding sequence should explain the product first.

Then permissions should be requested when their value is understood.

The user should be able to associate:

```text
Permission
   ↓
What it enables
   ↓
Why it matters
```

The initial trial should prioritize understanding and trust.

Stronger permissions can be introduced when the user chooses stronger commitment.

---

# 33. Principle 31 — Product Rules Must Survive Implementation Pressure

A developer or AI agent may encounter a situation where implementing a restriction is difficult.

The answer must not automatically be:

> "Let's remove the restriction."

Instead:

```text
Desired behavior
      ↓
Technical obstacle
      ↓
Investigate Android capability
      ↓
Evaluate alternatives
      ↓
Document limitation
      ↓
Decide explicitly
```

Implementation convenience is not sufficient reason to weaken the product.

---

# 34. Principle 32 — Do Not Over-Engineer the MVP

The first version must prove the fundamental hypothesis:

> **Can an Android smartphone genuinely feel like a useful keypad phone without forcing the user to abandon essential modern tools?**

Do not build:

- accounts
- cloud synchronization
- remote accountability
- advanced analytics
- elaborate themes
- hardware integrations
- complex social features

until the core experience works.

---

# 35. Principle 33 — Every Future Feature Needs a Product Reason

Before adding a feature, answer:

```text
What problem does it solve?
Why does a keypad phone need it?
Does it increase or reduce distraction?
Does it preserve essential utility?
Does it add cognitive complexity?
Could it become an engagement mechanism?
```

A feature that cannot justify itself should not be added.

---

# 36. Principle 34 — Preserve a Clear Separation Between Product Truth and Technical Implementation

Requirements describe what should happen.

Architecture describes how it happens.

Implementation details must not silently redefine product behavior.

For example:

```text
Product requirement:
"User must be able to access essential authentication."

Technical implementation:
"Use the installed authenticator application."
```

If that technical approach fails, the requirement remains.

We find another implementation.

---

# 37. Principle 35 — The Agent Must Never Invent Product Decisions

If the documentation says:

```text
UNDISCIDED
```

the coding agent must not silently choose a permanent product behavior.

It should:

- identify the decision
- suggest reasonable alternatives
- ask for a decision when required
- or make a clearly documented temporary choice where explicitly permitted

---

# 38. Principle 36 — Documentation Is Part of the Product

The project is expected to evolve with AI-assisted development.

Therefore documentation is not optional paperwork.

Meaningful changes should update the relevant specification.

At minimum:

```text
Product behavior change
→ Product Requirements / Feature Spec

Architectural change
→ Technical Architecture / Decision Log

Android limitation discovered
→ Android Platform / Known Limitations

Implementation progress
→ Project State

Released behavior
→ Changelog
```

---

# 39. Principle 37 — One Source of Truth Per Decision

Avoid contradictory definitions across documents.

When a concept has an authoritative document, other documents should reference it rather than redefine it.

Examples:

```text
Product philosophy
→ Product Vision

Interaction rules
→ Navigation & Interaction Spec

Application classification
→ App Policy Engine

Commitment states
→ Commitment & Restriction Engine

Android capabilities
→ Android Platform Spec
```

---

# 40. Principle 38 — Current State Must Always Be Recoverable

An AI agent joining an existing project must be able to understand:

- what has been built
- what is being built
- what is broken
- what is blocked
- what is next
- what should not be touched

This information belongs in `PROJECT_STATE.md`.

---

# 41. Principle 39 — Decision History Matters

When a major architectural or product decision changes, the reason should be recorded.

The project must preserve:

```text
What was decided?
Why?
What alternatives were rejected?
What assumptions were involved?
What future conditions might justify revisiting it?
```

This protects the project from repeatedly relitigating old decisions or accidentally reversing important choices.

---

# 42. Principle 40 — Optimize for the User's Six-Month Experience

Do not judge the product only by whether the first five minutes are impressive.

A feature should be evaluated against the long-term behavior we want.

The important question is:

> **Will this still help the user six months from now?**

A flashy feature that feels impressive during onboarding but recreates smartphone dependency should be rejected.

---

# 43. Principle 41 — The Phone Should End Tasks

A successful interaction should naturally terminate.

Example:

```text
Need address
   ↓
Open Maps
   ↓
Navigate
   ↓
Finish
   ↓
Return to Phone
```

Not:

```text
Need address
   ↓
Open Maps
   ↓
Notification
   ↓
Search something else
   ↓
YouTube
   ↓
Feed
   ↓
45 minutes
```

The system should favor task completion.

---

# 44. Principle 42 — Empty Time Is Allowed

The product should not feel responsible for entertaining the user.

If there is nothing essential to do:

> **Nothing needs to happen.**

This is a feature.

Optional future activities such as:

- music
- journaling
- offline games
- reading

must remain clearly subordinate to the phone's core purpose and must not become new attention loops.

---

# 45. Principle 43 — Customization Is Secondary

Extensive customization is not an MVP priority.

Users may eventually be able to change:

- themes
- colors
- fonts
- keypad styles
- sounds
- layouts

But the initial product should establish one strong, coherent experience.

Too much customization risks turning the product back into a typical launcher.

---

# 46. Principle 44 — The Product Should Feel Like a Real Device

Visual and interaction details should reinforce the mental model.

This includes:

- keypad proportions
- D-pad
- soft keys
- phone-like menus
- focus states
- tactile feedback
- appropriate sounds
- status information
- interaction patterns

The goal is not retro cosplay.

The goal is a credible alternate form of the phone.

---

# 47. Principle 45 — Modern Apps May Be Imperfect

The product cannot control every aspect of third-party applications.

A banking application may look modern.

WhatsApp may contain distracting features.

Maps may show additional content.

A payment application may show offers.

The launcher should control what it reasonably can without attempting to secretly rewrite third-party applications.

When third-party UI cannot be transformed, preserve functionality and keep the overall experience intentional.

---

# 48. Principle 46 — Do Not Break Legitimate Modern Life

The product must recognize that the real world is not a 2005 world.

Users may genuinely need:

- two-factor authentication
- digital payments
- QR codes
- maps
- workplace software
- modern messaging
- banking
- email
- browser access

The product's job is not to force ideological purity.

It is to make modern technology usable **without requiring the full smartphone lifestyle**.

---

# 49. Principle 47 — The Browser Is a Special Risk

The internet is both a utility and a major escape route.

Therefore browser access should be treated as a special product problem.

We should preserve:

- information access
- work
- services
- research
- necessary websites

while reducing:

- infinite feeds
- entertainment
- social platforms
- casual wandering

The final solution may require a controlled browsing layer.

The MVP must avoid prematurely overbuilding this area.

---

# 50. Principle 48 — No Hidden Backdoors for Convenience

The product must not quietly provide alternate routes to blocked applications merely because they make development or testing easier.

Examples include:

- hidden menus
- debug launchers accidentally left enabled
- undocumented unrestricted app search
- unprotected settings paths

Development backdoors must be clearly separated from production behavior.

---

# 51. Principle 49 — Recovery Must Be Designed, Not Improvised

Recovery should be considered for:

- crashes
- reboots
- missing permissions
- uninstalled applications
- launcher removal
- corrupted state
- unexpected Android behavior
- device updates

A commitment system is only trustworthy if users can safely recover from failure.

---

# 52. Principle 50 — Accessibility Is Not a Distraction

Accessibility should not be sacrificed for aesthetic purity or retro behavior.

The final product should account for:

- visual accessibility
- touch accessibility
- text scaling
- focus visibility
- haptics
- audio feedback
- motor accessibility
- screen readers where applicable

The keypad metaphor should enhance usability, not make the product inaccessible.

---

# 53. Principle 51 — Measure Product Success by Behavior, Not Engagement

A normal app might optimize for:

> More sessions. More time. More engagement.

This product should optimize in the opposite direction.

Potential long-term success indicators:

- less unnecessary screen time
- fewer distraction-app accesses
- fewer compulsive unlocks
- higher completion of necessary tasks
- sustained use of the launcher
- user-reported sense of control

More time inside the launcher is not inherently good.

---

# 54. Principle 52 — The Product Should Help Users Leave the Phone

The ultimate success condition is not:

> "Users spend more time using our launcher."

It is:

> **"Users use the phone, finish what they came to do, and put it away."**

The product should therefore never intentionally optimize for session duration.

---

# 55. Principle 53 — Local First for V1

The initial product should minimize infrastructure.

Preferred direction:

```text
No account
No required backend
No cloud dependency
Local configuration
Local policy
Local commitment state
Local accountability PIN
```

Cloud/account features may be added later if they provide meaningful value.

---

# 56. Principle 54 — Build Broadly, Validate Narrowly

The architecture should target Android broadly.

Testing may begin on a small number of representative devices.

For example:

```text
Development:
One primary device

Validation:
Representative Android devices/OEMs

Release:
Compatibility matrix
```

Do not mistake testing on one device for platform support.

---

# 57. Principle 55 — Product Quality Includes Restraint

A high-quality implementation is not the one with the most features.

It is the one where every included feature earns its place.

The product should repeatedly ask:

> **Could we remove this and make the phone better?**

If yes, removal may be the correct design.

---

# 58. Decision Rule for Ambiguous Features

When a feature is proposed and its value is unclear, evaluate it using this sequence:

```text
1. Does it solve a genuine user problem?
        ↓
2. Is the problem relevant to a keypad-phone experience?
        ↓
3. Does it preserve necessary capability?
        ↓
4. Does it increase or decrease distraction?
        ↓
5. Does it add cognitive complexity?
        ↓
6. Does it create an engagement loop?
        ↓
7. Can the same value be achieved more simply?
        ↓
8. Is it necessary now, or can it wait?
```

Prefer:

> **simple + useful + low-distraction + reliable**

over:

> **feature-rich + clever + engaging**

---

# 59. Priority Rule

When principles conflict, use this order:

```text
1. Safety / emergency functionality
2. Essential real-world functionality
3. User's explicit commitment
4. Privacy and security
5. Simplicity
6. Low distraction
7. Performance / reliability
8. Aesthetic preference
9. Customization
10. Novelty
```

This hierarchy should guide difficult decisions.

---

# 60. Final Product Test

Before accepting a meaningful feature or architectural change, ask:

### Does this help turn the smartphone into a better phone?

If yes, continue evaluating it.

### Does this merely make the smartphone prettier?

Probably not important.

### Does this make the smartphone more capable but also more distracting?

Require strong justification.

### Does this recreate the very behavior the product exists to eliminate?

Reject it unless there is an exceptionally strong reason.

---

# 61. The North-Star Test

Every significant decision should be defensible against this sentence:

> **"The user should be able to use modern technology when they genuinely need it, without having to live inside a modern smartphone experience."**

And the ultimate product statement remains:

> **The phone is a tool. The user is in control.**
