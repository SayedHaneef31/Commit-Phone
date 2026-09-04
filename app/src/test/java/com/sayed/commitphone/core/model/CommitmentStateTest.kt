package com.sayed.commitphone.core.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CommitmentStateTest {
    @Test
    fun defaultStateIsTrial() {
        val state = CommitmentState()
        assertEquals(CommitmentMode.TRIAL, state.mode)
        assertFalse(state.isTrialActive)
        assertFalse(state.accountabilityEnabled)
    }

    @Test
    fun committedModeCanBeSet() {
        val state = CommitmentState(mode = CommitmentMode.COMMITTED)
        assertEquals(CommitmentMode.COMMITTED, state.mode)
    }

    @Test
    fun hardcoreModeCanBeSet() {
        val state = CommitmentState(mode = CommitmentMode.HARDCORE)
        assertEquals(CommitmentMode.HARDCORE, state.mode)
    }
}
