package com.sayed.commitphone.core.model

data class AppRecord(
    val packageName: String,
    val label: String,
    val activityName: String? = null,
    val isInstalled: Boolean = true,
)
