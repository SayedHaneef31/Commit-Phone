# 22 — Release and Distribution

## Purpose

Defines release discipline for internal builds, beta, and eventual Play Store distribution.

## Build Types

### Debug
- developer logging
- test tools
- no production bypasses

### Internal
- realistic permission/restriction behavior
- crash monitoring as appropriate

### Beta
- representative devices
- documented known limitations

### Production
- signed release
- validated migration
- release notes
- rollback/recovery plan

---

# Release Checklist

- [ ] build reproducible
- [ ] tests passing
- [ ] no known P0
- [ ] permissions reviewed
- [ ] privacy disclosures reviewed
- [ ] target SDK requirements validated
- [ ] Play Store policies reviewed
- [ ] compatibility status updated
- [ ] migration tested
- [ ] emergency recovery tested
- [ ] documentation updated

---

# Versioning

Use semantic intent:
- major: incompatible product/architecture changes
- minor: meaningful product features
- patch: fixes

Exact versioning scheme can be formalized later.

---

# Distribution Strategy

Initial:
- local development
- internal APK/test track

Future:
- Play Store testing
- limited beta
- production

---

# Important

The product uses potentially sensitive Android permissions/capabilities. Store distribution requirements must be reviewed before each release rather than assuming permission availability is equivalent to Play Store permission to use it.
