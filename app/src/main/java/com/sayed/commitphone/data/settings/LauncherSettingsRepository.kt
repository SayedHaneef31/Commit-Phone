package com.sayed.commitphone.data.settings

import kotlinx.coroutines.flow.Flow

/** Small, user-controlled launcher preferences belong in DataStore rather than the policy engine. */
interface LauncherSettingsRepository {
    val showStatus: Flow<Boolean>
}
