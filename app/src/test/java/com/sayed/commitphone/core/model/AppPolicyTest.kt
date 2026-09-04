package com.sayed.commitphone.core.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AppPolicyTest {
    @Test
    fun policyCanBeCreatedForDisallowedApp() {
        val policy = AppPolicy(
            packageName = "com.example.instagram",
            category = AppCategory.DISALLOWED,
            decision = AppPolicyDecision.DENY,
            reason = "Social media",
        )
        assertEquals("com.example.instagram", policy.packageName)
        assertEquals(AppCategory.DISALLOWED, policy.category)
        assertEquals(AppPolicyDecision.DENY, policy.decision)
        assertEquals("Social media", policy.reason)
    }

    @Test
    fun policyCanBeCreatedForEssentialTool() {
        val policy = AppPolicy(
            packageName = "com.google.android.apps.maps",
            category = AppCategory.ESSENTIAL_TOOL,
            decision = AppPolicyDecision.ALLOW,
        )
        assertEquals(AppPolicyDecision.ALLOW, policy.decision)
        assertTrue(policy.reason.isEmpty())
    }
}
