package com.sayed.commitphone.core.model

data class AppPolicy(
    val packageName: String,
    val category: AppCategory,
    val decision: AppPolicyDecision,
    val reason: String = "",
)
