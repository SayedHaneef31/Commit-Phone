package com.sayed.commitphone.core.model

data class CommitmentState(
    val mode: CommitmentMode = CommitmentMode.TRIAL,
    val isTrialActive: Boolean = false,
    val accountabilityEnabled: Boolean = false,
)
