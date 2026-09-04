# 02 — Product Requirements Specification

## 1. Document Purpose

This document defines the formal functional and non-functional requirements for the product.

`00_PRODUCT_VISION.md` defines **what the product is**.

`01_PRODUCT_PRINCIPLES.md` defines **how product decisions should be made**.

This document defines:

> **What the product must actually do.**

Requirements are written to be testable wherever practical.

Each requirement includes:

- Requirement ID
- Description
- Priority
- Target phase
- Acceptance criteria
- Dependencies or notes where useful

---

# 2. Requirement Conventions

## Priority

### P0 — Critical

Required for the core product to function.

A P0 requirement should not be casually deferred.

### P1 — Important

Required for a credible first production version, but not necessarily needed for the earliest functional prototype.

### P2 — Future enhancement

Useful, but not required to prove the core product hypothesis.

---

## Product Phases

### MVP

The smallest version capable of demonstrating the core product hypothesis.

### V1

The first mature consumer-ready version.

### V2+

Future improvements after the fundamental product has been validated.

---

## Status

Requirements may use:

- `PROPOSED`
- `APPROVED`
- `IN PROGRESS`
- `IMPLEMENTED`
- `BLOCKED`
- `DEFERRED`
- `REJECTED`

---

# 3. Core Product Requirements

## FR-001 — Android HOME Experience

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The application SHALL be capable of functioning as the user's Android HOME/launcher experience on supported Android devices.

### Acceptance criteria

- The application can be selected as the device's default HOME application.
- Pressing the system Home action returns the user to the product's home experience when configured as the active launcher.
- The launcher handles returning from launched applications appropriately.
- The product must not assume Samsung-specific launcher behavior.

---

## FR-002 — Keypad-Phone Home Experience

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The launcher SHALL provide a home experience that visually and behaviorally resembles a traditional keypad phone.

### Acceptance criteria

The default home screen includes, where supported by the device:

- Clock
- Date
- Status information
- Phone-like keypad
- D-pad/navigation controls
- Soft-key actions
- Phone-like visual hierarchy

The keypad must be an actual interactive control surface and not merely a visual element.

---

## FR-003 — Functional Numeric Keypad

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide an interactive numeric keypad.

### Acceptance criteria

- Keys `0–9`, `*`, and `#` are available where relevant.
- Key presses produce visible and/or tactile feedback.
- Numeric input can be used for supported product functions.
- The keypad remains present on screens where the product controls the full UI, except where the product explicitly determines that a full-screen experience is required.
- Keypad behavior must be consistent across the product.

---

## FR-004 — D-Pad Navigation

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide a D-pad interaction model.

### Acceptance criteria

- Up, Down, Left, Right, and Center/OK actions are supported.
- Focusable items can be navigated using the D-pad.
- Focus state is visually clear.
- The D-pad is the preferred navigation mechanism for product-controlled interfaces.
- Touch remains available where explicitly defined by the interaction specification.

---

## FR-005 — Touch as Secondary Input

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Touch interaction SHALL remain available where D-pad/keypad interaction is impractical or where a third-party/system application requires touch.

### Acceptance criteria

- Product-controlled screens remain usable with D-pad.
- Touch does not automatically replace keypad-first navigation.
- Modern applications may use their own touch-first interaction model.
- The product must not force D-pad interaction into interfaces where that would make essential tasks unusable.

---

# 4. Home and Navigation Requirements

## FR-006 — Phone-Like Home Screen

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The home screen SHALL prioritize phone status and navigation rather than application discovery.

### Acceptance criteria

The home screen SHALL NOT behave like a conventional Android app grid.

It should prioritize:

- Time
- Date
- Status
- Primary phone controls
- Menu access
- Phone-like navigation

The default home screen should not expose social media, entertainment, games, or recommendation feeds.

---

## FR-007 — Menu System

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The launcher SHALL provide a phone-like menu containing core functions and approved modern tools.

### Initial menu categories/functions may include:

- Phone
- Contacts
- Messages
- Camera
- Gallery
- Clock
- Calendar
- Calculator
- Notes
- Files
- Weather
- QR Scanner
- Connectivity
- Email
- Browser
- Approved modern apps
- Settings

### Acceptance criteria

- Menu can be opened from the home experience.
- Menu is navigable with D-pad.
- Menu is usable without touch.
- Menu does not expose prohibited applications.

---

## FR-008 — Menu Simplicity

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The initial product SHALL use a simple, primarily linear menu structure.

Advanced categorization, app search, and extensive customization are deferred unless needed.

---

# 5. Core Phone Function Requirements

## FR-009 — Phone Calls

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL preserve normal phone call functionality.

### Acceptance criteria

- User can initiate calls.
- Incoming calls remain functional.
- Call-related emergency functionality is not obstructed.
- Recent calls can be reached through the product where technically feasible.
- Essential phone functionality must not depend on optional distraction-control permissions.

---

## FR-010 — Contacts

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide access to the device's contacts.

### Acceptance criteria

- Contacts can be opened from the product.
- Contacts can be navigated with D-pad where product-controlled.
- Selecting a contact can initiate supported actions such as calling or messaging.
- The product must preserve the underlying device's contact data rather than create an unnecessary duplicate source of truth in MVP.

---

## FR-011 — SMS/MMS

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL preserve SMS/MMS functionality.

### Acceptance criteria

- User can access existing messages.
- User can send supported messages.
- User can receive supported messages.
- Emergency/system messaging behavior is not intentionally broken.
- Product architecture must account for Android's default SMS application rules where relevant.

---

## FR-012 — Camera

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide access to the device's camera.

### Acceptance criteria

- Camera can be opened quickly.
- Photo capture works.
- Video capture works.
- Product should prefer the device's existing camera capabilities in MVP.
- The product should not unnecessarily replace a capable OEM camera.

---

## FR-013 — Gallery

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide access to stored photos and videos.

The first version may use the device's existing gallery/photo application rather than implementing a custom gallery.

---

## FR-014 — Clock and Alarms

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL expose practical clock functionality.

Expected capabilities include:

- Time
- Date
- Alarm
- Timer
- Stopwatch
- World clock where available

The MVP may initially use native/system capabilities.

---

## FR-015 — Calendar

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide access to calendar functionality.

The MVP may use the user's existing calendar application or Android calendar capabilities before a custom calendar UI is implemented.

---

## FR-016 — Calculator

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide calculator functionality.

The initial implementation may use a native calculator or a custom lightweight calculator.

---

## FR-017 — Notes

**Priority:** P1  
**Phase:** MVP/V1  
**Status:** PROPOSED

The product SHOULD provide lightweight note-taking.

The initial implementation should favor simplicity over feature richness.

---

## FR-018 — File Management

**Priority:** P1  
**Phase:** V1  
**Status:** PROPOSED

The product SHOULD provide minimal file-management access.

It should prioritize:

- Opening files
- Basic navigation
- Essential file actions

It should not become a full file-management suite in MVP.

---

# 6. Connectivity and Practical Utility Requirements

## FR-019 — Wi-Fi

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The user SHALL be able to access and manage Wi-Fi through an appropriate Android/system interface.

---

## FR-020 — Bluetooth

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL preserve Bluetooth functionality.

It should work with essential devices such as:

- headphones
- speakers
- vehicles
- watches
- peripherals

---

## FR-021 — Hotspot

**Priority:** P1  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL preserve mobile hotspot functionality where supported by the device.

---

## FR-022 — Flashlight

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The user SHALL have convenient access to the flashlight.

---

## FR-023 — Weather

**Priority:** P1  
**Phase:** MVP/V1  
**Status:** PROPOSED

The product SHOULD provide basic weather information without introducing a feed-based or engagement-oriented experience.

---

## FR-024 — QR Scanning

**Priority:** P1  
**Phase:** MVP/V1  
**Status:** APPROVED

The product SHOULD provide convenient QR scanning.

The implementation may use an appropriate native capability or dedicated scanning flow.

---

## FR-025 — Email

**Priority:** P1  
**Phase:** MVP/V1  
**Status:** APPROVED

The product SHALL permit access to essential email.

Email may use the user's existing email application in MVP.

---

# 7. Screenshot / Screen Recording Requirements

## FR-026 — Screenshot Is Not a Product Feature

**Priority:** P2  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL NOT provide a dedicated screenshot feature as part of the keypad experience.

This does not necessarily prevent Android's underlying system screenshot mechanism from existing where the platform requires or provides it.

---

## FR-027 — Screen Recording Is Not a Product Feature

**Priority:** P2  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL NOT provide a dedicated screen-recording feature.

---

# 8. Modern Essential Application Requirements

## FR-028 — User-Specific Essential Applications

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL support a user-specific set of legitimate modern applications.

Possible examples include:

- Navigation
- Authentication
- UPI/payment
- Banking
- WhatsApp
- Work applications
- Email
- Other legitimate utilities

The list must not be treated as a universally fixed list.

---

## FR-029 — Essential Application Selection

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

During onboarding, the user SHALL be able to identify the modern applications they genuinely need.

The selection must be evaluated by the application policy system.

---

## FR-030 — Application Policy Evaluation

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Every user-requested third-party application SHALL be evaluated before being permanently admitted into the phone's allowed application set.

The policy system should classify applications according to product rules.

---

## FR-031 — Allowed Application Categories

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The application policy system SHALL support, at minimum:

- Core
- Essential tool
- Utility
- Work
- Communication
- Review
- Temporary
- Disallowed

The exact classification logic is defined in `10_APP_POLICY_ENGINE.md`.

---

## FR-032 — Disallowed Applications

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Applications whose primary purpose is social media, entertainment, gaming, short-form content, infinite feeds, or comparable distraction SHALL be considered incompatible with the core committed phone experience.

Examples may include:

- Instagram
- TikTok
- entertainment-first video applications
- games
- other known high-distraction applications

The policy engine, rather than an unmaintainable hardcoded blacklist alone, should own the classification model.

---

## FR-033 — User Request Rejection

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL be capable of rejecting an application the user requests if the application does not satisfy the product's allowed-use policy.

The UI must explain the decision respectfully rather than shaming the user.

---

## FR-034 — Ambiguous Application Review

**Priority:** P1  
**Phase:** MVP/V1  
**Status:** PROPOSED

Applications that cannot be confidently classified SHOULD enter a review flow.

The user may be asked why the application is required.

The system must not blindly accept an application simply because the user insists.

---

# 9. Application Visibility and Access Requirements

## FR-035 — Core Application Visibility

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Core phone capabilities SHALL remain discoverable through the product's normal menu.

---

## FR-036 — Disallowed Application Visibility

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Disallowed applications SHALL NOT appear in the normal launcher menu.

---

## FR-037 — Application Installation Detection

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL be able to detect relevant installed applications and changes in the installed application set where Android permits.

Examples:

- new application installed
- application removed
- package updated
- application becoming unavailable

---

## FR-038 — Newly Installed Application Handling

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

When a newly installed application conflicts with the active commitment policy, the product SHALL respond according to the active restriction mode.

Possible responses include:

- deny access through the launcher
- request review
- apply restrictions
- recommend removal
- provide temporary access where explicitly allowed

Exact enforcement depends on Android capabilities and the active device-management state.

---

# 10. Application Removal Requirements

## FR-039 — Distraction Cleanup Onboarding

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The onboarding process SHALL help the user remove major distracting applications without requiring the user to manually locate every application one at a time through Android settings.

The product should reduce setup burden.

---

## FR-040 — Bulk or Assisted Removal

**Priority:** P1  
**Phase:** MVP/V1  
**Status:** PROPOSED

Where Android APIs and platform policy permit, the product SHOULD provide an assisted or efficient workflow for removing multiple unwanted applications.

The product must not assume that arbitrary silent bulk uninstallation is available to an ordinary launcher.

---

## FR-041 — Progressive Cleanup

**Priority:** P1  
**Phase:** V1  
**Status:** PROPOSED

Applications not removed during initial onboarding MAY remain installed but hidden/restricted according to policy.

The product may periodically encourage cleanup rather than forcing the user to remove every application immediately.

---

# 11. Commitment Requirements

## FR-042 — Commitment Trial

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide an approximately three-day initial trial experience.

The trial exists to let users experience the phone transformation before making the strongest commitment.

---

## FR-043 — Trial Explanation

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Before trial activation, the product SHALL clearly explain:

- what the product changes
- what a keypad-phone experience means
- what happens to applications
- what distractions may be removed
- what permissions may eventually be required
- how the user can recover
- what stronger commitment means

---

## FR-044 — Trial Commitment

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The trial SHALL introduce meaningful friction against casually reverting to the normal launcher.

However, the earliest trial version may retain a technically recoverable exit path.

---

## FR-045 — Post-Trial Commitment Choice

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

At the end of the trial, the user SHALL be able to:

- continue with the product
- choose a stronger commitment mode where supported
- return to the device's normal Android launcher

The product must explain the trade-offs before stronger enforcement is enabled.

---

# 12. Commitment Mode Requirements

## FR-046 — Multiple Commitment Levels

**Priority:** P0  
**Phase:** MVP/V1  
**Status:** APPROVED

The product SHALL support multiple commitment strengths.

At minimum, the architecture must allow for:

- Trial
- Standard/Committed
- Hardcore

The final naming may be refined later.

---

## FR-047 — Strong Commitment Mode

**Priority:** P0  
**Phase:** V1  
**Status:** APPROVED

The strong commitment mode SHALL provide substantially stronger restriction of:

- disallowed applications
- launcher replacement
- commitment settings
- application-policy changes
- other known circumvention paths

Exact capabilities depend on Android platform mechanisms.

---

## FR-048 — Hardcore Mode

**Priority:** P0  
**Phase:** V1  
**Status:** APPROVED

The product SHALL aim to provide a highest-enforcement mode in which the device is as close as technically possible to a real dumb/keypad phone while retaining explicitly approved essential applications.

Hardcore mode should be built around Android-supported device-management capabilities where appropriate.

---

## FR-049 — Strong Commitment Requires Explicit Consent

**Priority:** P0  
**Phase:** MVP/V1  
**Status:** APPROVED

The product SHALL explicitly obtain user consent before enabling stronger device-management or restriction mechanisms.

---

## FR-050 — Configuration Lock

**Priority:** P0  
**Phase:** V1  
**Status:** APPROVED

Certain commitment settings SHALL be frozen for a configured period or until an approved accountability/recovery process is completed.

---

# 13. Accountability Requirements

## FR-051 — Local Accountability PIN

**Priority:** P1  
**Phase:** V1  
**Status:** APPROVED

The product SHALL support a local accountability PIN mechanism.

The intended setup is:

1. User chooses a trusted person.
2. Trusted person creates the PIN.
3. User is encouraged not to know the PIN.
4. The PIN is used for protected commitment-management operations.

---

## FR-052 — Accountability PIN Guidance

**Priority:** P1  
**Phase:** V1  
**Status:** APPROVED

During setup, the product SHOULD explicitly encourage the user to have someone else create the PIN rather than creating one they know.

The mechanism is intended primarily as a behavioral safeguard.

---

## FR-053 — Future Remote Accountability

**Priority:** P2  
**Phase:** V2+  
**Status:** DEFERRED

Future versions MAY support accounts, remote approval, accountability partners, or server-mediated one-time authorization.

No backend is required for the initial product.

---

# 14. Exit and Recovery Requirements

## FR-054 — Normal Exit

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide a recoverable path back to the device's normal Android launcher.

The exit flow should become deliberately harder in stronger commitment modes.

---

## FR-055 — Exit Friction

**Priority:** P0  
**Phase:** MVP/V1  
**Status:** APPROVED

Changing or disabling commitment settings SHALL introduce deliberate friction.

Possible mechanisms include:

- confirmation steps
- time delays
- accountability PIN
- stronger permission flow
- device-management confirmation
- temporary lockout periods

Exact implementation must conform to Android capabilities.

---

## FR-056 — Emergency Recovery

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide an emergency recovery path.

Emergency recovery must remain possible even if normal commitment controls are active.

---

## FR-057 — Safe Failure

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

If the launcher crashes, becomes disabled, or is removed, the device should be able to fall back to its normal Android launcher where possible.

The product must not intentionally create an unrecoverable phone state.

---

# 15. Notification Requirements

## FR-058 — Notification Access Strategy

**Priority:** P0  
**Phase:** MVP/V1  
**Status:** APPROVED

The product SHALL support a notification strategy that reduces distraction.

The initial strategy may use Android notification-access capabilities where appropriate and consented to by the user.

---

## FR-059 — Notification Filtering

**Priority:** P0  
**Phase:** V1  
**Status:** APPROVED

The system SHOULD prioritize notifications from:

- phone
- messages
- essential communication
- authentication
- banking/payment
- work
- other explicitly important applications

Distraction-oriented notifications should be suppressed, batched, or hidden according to commitment policy.

---

## FR-060 — No Notification Badges

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL NOT use conventional notification badges as a core interaction pattern.

---

## FR-061 — Notification Sounds/Vibration

**Priority:** P1  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL preserve appropriate notification sounds/vibration for essential communication and system events unless the user explicitly disables them.

The launcher should not intentionally turn all notifications into constant attention triggers.

---

# 16. Browser Requirements

## FR-062 — Internet Availability

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL NOT intentionally disconnect the user from the internet.

Users must retain legitimate internet access.

---

## FR-063 — Browser Availability

**Priority:** P1  
**Phase:** MVP/V1  
**Status:** APPROVED

The product SHALL allow access to a browser or browser-based functionality for legitimate needs.

The exact MVP browser architecture remains subject to platform/technical investigation.

---

## FR-064 — Browser Distraction Strategy

**Priority:** P0  
**Phase:** V1/V2  
**Status:** PROPOSED

The long-term browser strategy SHOULD preserve legitimate information/service access while restricting or adding friction to known distraction destinations.

Potential areas include:

- social networks
- short-form video
- entertainment feeds
- infinite-scrolling services

---

## FR-065 — No Artificial Network Throttling as Primary Solution

**Priority:** P1  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL NOT rely on arbitrary network-speed reduction as its primary distraction-control mechanism.

The preferred direction is intentional access control or friction rather than degraded internet service.

---

# 17. Third-Party Application Requirements

## FR-066 — Native Application Preservation

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Essential third-party applications may remain fully native in MVP.

The launcher should provide access without attempting to rewrite their internal interfaces.

---

## FR-067 — Third-Party Application Full-Screen Exceptions

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Applications requiring rich interaction MAY temporarily occupy the full available screen and hide the keypad when necessary.

Examples:

- navigation
- authentication
- banking
- QR/payment flows
- complex native applications

---

## FR-068 — Return to Phone Experience

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

After completing a third-party application task and leaving the application, the user should return naturally to the keypad-phone environment.

---

## FR-069 — Future Custom T9 Input

**Priority:** P2  
**Phase:** V2+  
**Status:** DEFERRED

The architecture SHOULD allow future development of a custom T9/input-method solution that can extend keypad-style typing into third-party applications.

---

# 18. Keypad and Text Input Requirements

## FR-070 — Keypad-First Text Entry Goal

**Priority:** P1  
**Phase:** V1/V2  
**Status:** APPROVED

The long-term product SHALL support keypad-based text entry.

---

## FR-071 — T9

**Priority:** P1  
**Phase:** V1/V2  
**Status:** APPROVED

The product should eventually support T9-style typing where practical.

The MVP does not require full T9 implementation.

---

## FR-072 — Normal Keyboard Fallback

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Where keypad-based input cannot reasonably be provided, users must be able to use the normal Android keyboard.

The product must prioritize successful completion of essential tasks over ideological purity.

---

# 19. Native System Integration Requirements

## FR-073 — Preserve System Connectivity

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL preserve normal device connectivity.

---

## FR-074 — Preserve Emergency Features

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

System emergency functionality SHALL remain intact.

---

## FR-075 — Preserve Essential Authentication

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Approved authentication applications and required authentication flows SHALL remain usable without unnecessary friction.

---

## FR-076 — Preserve Banking and Payments

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Approved banking and UPI/payment applications SHALL remain usable normally.

These applications should not receive artificial friction merely because they are modern applications.

---

# 20. Permissions and Privacy Requirements

## FR-077 — Progressive Permission Requests

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL avoid requesting every powerful permission immediately without contextual explanation.

Permissions should be requested progressively when their purpose is understandable.

---

## FR-078 — Permission Explanation

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Before requesting sensitive permissions, the product SHALL explain:

- what the permission enables
- why the product needs it
- whether it is optional
- what happens if the user denies it

---

## FR-079 — No Unnecessary Permissions

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL request only permissions required for implemented functionality.

---

## FR-080 — Local-First Core Operation

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The core launcher SHALL function without requiring:

- user account
- remote backend
- cloud synchronization

---

## FR-081 — Data Minimization

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL minimize collection and storage of user data.

---

# 21. Performance Requirements

## NFR-001 — Lightweight Runtime

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The launcher SHALL be lightweight and responsive.

It should minimize:

- memory usage
- CPU usage
- background processing
- unnecessary wakeups
- battery consumption

---

## NFR-002 — Fast Home Launch

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Returning to the launcher should feel immediate on supported devices.

---

## NFR-003 — No Unnecessary Background Services

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Background services SHALL only exist when required by a real product function.

---

# 22. Android Compatibility Requirements

## NFR-004 — Broad Android Support

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL target Android broadly rather than a single OEM.

---

## NFR-005 — OEM Independence

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The architecture SHALL avoid Samsung-specific dependencies as a core requirement.

Initial testing may use an S24 Ultra, but the product must be designed for Android devices generally.

---

## NFR-006 — Lower-End Device Graceful Degradation

**Priority:** P1  
**Phase:** V1  
**Status:** APPROVED

The product SHOULD gracefully degrade or disable advanced features on devices that cannot support them reliably.

A small percentage of very old/incompatible devices may be excluded if necessary.

---

# 23. Visual and Interaction Requirements

## NFR-007 — Keypad Phone Aesthetic

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The interface SHALL visually resemble a real keypad phone.

It should not merely place minimalist widgets on an Android home screen.

---

## NFR-008 — Black Initial Theme

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The initial product SHALL use a predominantly black visual theme.

---

## NFR-009 — Moderate Visual Character

**Priority:** P1  
**Phase:** MVP  
**Status:** APPROVED

The visual product should balance:

- simplicity
- retro character
- usability
- visual quality

It should feel approximately moderate on a boring-to-cool scale rather than either extremely boring or highly decorative.

---

## NFR-010 — Minimal Motion

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Animations should communicate interaction and state rather than encourage engagement.

---

# 24. Settings Requirements

## FR-082 — Product Settings

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL provide a simplified settings environment.

Likely initial areas include:

- Sound
- Display
- Connectivity
- Apps
- Phone
- Date & Time
- Security
- Commitment
- About

---

## FR-083 — Protected Commitment Settings

**Priority:** P0  
**Phase:** V1  
**Status:** APPROVED

Commitment-related settings SHALL be protected according to the active commitment mode.

---

## FR-084 — System Settings Access

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product must maintain a recoverable path to required Android system settings.

Stronger commitment modes may add friction to selected configuration paths where Android permits.

---

# 25. Failure and Recovery Requirements

## FR-085 — Launcher Crash Recovery

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

A launcher crash must not permanently render the device unusable.

---

## FR-086 — Missing Permission Handling

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

If an important optional permission is revoked, the product SHALL:

- detect the degraded state where possible
- explain the effect
- provide a recovery path
- continue functioning in the least-restricted safe state possible

---

## FR-087 — Missing Essential App Handling

**Priority:** P1  
**Phase:** V1  
**Status:** PROPOSED

If an essential application is removed or becomes unavailable, the product SHOULD clearly indicate the problem and provide an appropriate remediation path.

---

# 26. Onboarding Requirements

## FR-088 — Product Explanation

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Onboarding SHALL clearly explain that the user is not installing an ordinary launcher.

The user is opting into a transformed phone experience.

---

## FR-089 — Interactive Demonstration

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Users SHALL be shown or allowed to experience the key interactions before stronger commitment.

The demonstration should cover:

- home
- keypad
- D-pad
- menu
- launching tools
- returning to the phone
- commitment concept

---

## FR-090 — Setup Duration

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The complete initial setup should target approximately 5–10 minutes.

It may be longer than a typical launcher because the product is asking for a meaningful behavioral commitment.

---

## FR-091 — User Understanding Before Commitment

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

The product SHALL require explicit acknowledgment before enabling stronger restrictions.

---

# 27. Optional Future Activity Requirements

## FR-092 — Low-Arousal Optional Activities

**Priority:** P2  
**Phase:** V2+  
**Status:** DEFERRED

Future versions MAY provide low-arousal activities such as:

- music
- journaling
- offline games
- reading

These must remain subordinate to the primary goal and must not evolve into attention-capture systems.

---

# 28. Usage Statistics Requirements

## FR-093 — Usage Statistics

**Priority:** P2  
**Phase:** V2+  
**Status:** DEFERRED

Future versions MAY provide usage statistics.

Potential information:

- screen time
- app usage
- distraction attempts
- necessary-task usage
- usage trends

The feature should be evaluated carefully because a usage dashboard can itself become an attention loop.

---

# 29. Account and Backend Requirements

## FR-094 — No Required Account in MVP

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Users SHALL NOT need to create an account to use the core launcher.

---

## FR-095 — No Required Backend in MVP

**Priority:** P0  
**Phase:** MVP  
**Status:** APPROVED

Core functionality SHALL NOT depend on a backend.

---

# 30. Business Requirements

## BR-001 — Product Should Be Monetizable

**Priority:** P2  
**Phase:** Future  
**Status:** PROPOSED

The product should eventually support a sustainable paid model.

Potential approaches may include:

- free tier
- one-time purchase
- subscription
- paid add-ons

The exact model is undecided.

---

# 31. Explicitly Out of Scope for MVP

The following are intentionally NOT required for the first meaningful MVP:

```text
Account system
Cloud sync
Remote accountability
Advanced usage analytics
Themes
Multiple phone skins
Advanced customization
Music player
FM radio
Voice recorder
Screen recording
Custom gallery
Complete custom dialer
Complete custom messaging application
Fully custom browser
Advanced T9/IME
Hardware integrations
Remote device management
Complex AI-based app classification
```

These may be added later if justified.

---

# 32. MVP Definition

The MVP is successful when a user can:

1. Install the application.
2. Understand what it does.
3. Set it as the launcher.
4. Enter the keypad-phone experience.
5. Navigate the launcher with the D-pad.
6. Use the functional keypad.
7. Access core phone functionality.
8. See a simple menu.
9. Launch approved modern applications.
10. Keep legitimate essential tools available.
11. Hide/restrict known distraction applications from the launcher.
12. Experience meaningful commitment friction.
13. Complete legitimate daily tasks.
14. Return safely to the normal Android launcher if necessary.
15. Do all of this without relying on Samsung-specific architecture.

The MVP does NOT need to perfectly recreate every physical keypad-phone application.

The MVP must prove the central hypothesis:

> **A modern Android smartphone can become a genuinely useful keypad phone without forcing the user to abandon the essential modern technology they need.**

---

# 33. Requirement Completion Rule

A requirement SHALL NOT be considered complete simply because the code compiles.

For a requirement to be marked `IMPLEMENTED`, it must satisfy:

```text
Implementation exists
        +
Expected behavior works
        +
Relevant edge cases considered
        +
Relevant tests exist where practical
        +
Documentation is consistent
        +
No known critical regression
```

---

# 34. Requirement Change Rule

When a requirement changes:

1. Update this document.
2. Update the relevant feature specification.
3. Record the reason in `23_DECISION_LOG.md`.
4. Update implementation status.
5. Update `27_PROJECT_STATE.md` when relevant.
6. Update `26_CHANGELOG.md` when the change affects released or externally visible behavior.

No major requirement should be silently changed inside code.

---

# 35. Final Requirement Principle

The full requirements set exists to support one outcome:

> **The user should be able to live with the capabilities of a modern smartphone without having to live with the behavioral environment of a modern smartphone.**
