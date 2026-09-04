package com.sayed.commitphone.data.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreLauncherSettingsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : LauncherSettingsRepository {
    override val showStatus: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[SHOW_STATUS] ?: true
    }

    private companion object {
        val SHOW_STATUS = booleanPreferencesKey("show_status")
    }
}
