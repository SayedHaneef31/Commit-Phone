package com.sayed.commitphone.data.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.launcherDataStore: DataStore<Preferences> by preferencesDataStore(name = "launcher_settings")

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBindingModule {
    @Binds
    @Singleton
    abstract fun bindLauncherSettingsRepository(
        implementation: DataStoreLauncherSettingsRepository,
    ): LauncherSettingsRepository
}

@Module
@InstallIn(SingletonComponent::class)
object SettingsModule {
    @Provides
    @Singleton
    fun provideLauncherDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.launcherDataStore
}
