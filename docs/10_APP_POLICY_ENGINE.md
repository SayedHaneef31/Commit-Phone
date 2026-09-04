# 10 — App Policy Engine

## Purpose
The policy engine decides which applications belong in the user's committed phone environment.

## Core principle

> The app is a tool only when its primary role is genuinely useful to the user's life or work.

The system should be firm but not irrational.

---

# 1. Policy Categories

```text
CORE
ESSENTIAL
UTILITY
WORK
COMMUNICATION
REVIEW
TEMPORARY
DISALLOWED
```

## CORE
Built-in phone capabilities or universally expected utilities.

## ESSENTIAL
Legitimate modern tools the user genuinely needs.

Examples:
- Maps
- authenticator
- banking
- UPI

## UTILITY
Useful practical tools.

## WORK
Legitimate workplace applications.

## COMMUNICATION
Communication applications. These may require nuanced handling.

## REVIEW
Ambiguous or mixed-purpose applications.

## TEMPORARY
Useful occasionally but not appropriate for constant availability.

## DISALLOWED
Primarily entertainment, social consumption, gaming, or comparable attention capture.

---

# 2. Evaluation Inputs

Potential inputs:
- package identifier
- app label
- manifest metadata available to the launcher
- known application classification
- user explanation
- current commitment mode
- prior policy decision

Do not inspect private app content merely to classify it.

---

# 3. Decision Outputs

```text
ALLOW
ALLOW_WITH_FRICTION
REVIEW
TEMPORARY_ONLY
HIDE
RESTRICT
DENY
```

The enforcement capability depends on Android state.

---

# 4. Initial Rules

Likely allow:
- navigation
- authentication
- banking
- payment
- practical work tools

Likely deny:
- social media
- games
- entertainment-first streaming
- infinite-feed applications

Review:
- mixed-purpose communication
- mixed-purpose content
- ambiguous work apps
- music/media tools
- browser alternatives

---

# 5. Intelligence Strategy

MVP should prefer a deterministic policy system.

Do not make the product dependent on a local AI model for basic classification.

A future intelligence layer may use:
- maintained application metadata
- product category knowledge
- behavior classification
- contextual reasoning

But the policy decision must remain inspectable.

---

# 6. User Review

For REVIEW:

```text
This app is not automatically approved.

Why do you need it?
[Work]
[Navigation]
[Communication]
[Other]
```

The response can inform the policy decision.

The user may not automatically override a prohibited category.

---

# 7. Policy Record

```text
AppPolicy {
    packageId
    category
    decision
    reason
    commitmentScope
    createdAt
    updatedAt
}
```

---

# 8. Policy Changes

A policy change during strong commitment should itself be a protected operation.

---

# 9. New App Handling

When a new app appears:
1. identify it
2. evaluate policy
3. apply current commitment behavior
4. do not expose it in normal navigation until approved if policy requires review

---

# 10. Policy Explainability

When denying:
- be brief
- be factual
- avoid shame
- explain that the app conflicts with the selected commitment

Example:
> This app is primarily designed for social/entertainment consumption and is not available in your current phone mode.

---

# 11. Future Learning

The system may later learn from:
- user-approved work tools
- repeated review decisions
- policy updates

Learning must never silently weaken the core restriction model.
