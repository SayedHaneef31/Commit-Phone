package com.sayed.commitphone.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sayed.commitphone.core.navigation.Destination
import com.sayed.commitphone.data.settings.LauncherSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class LauncherUiState(
    val destination: Destination = Destination.Home,
    val showStatus: Boolean = true,
)

@HiltViewModel
class LauncherViewModel @Inject constructor(
    settingsRepository: LauncherSettingsRepository,
) : ViewModel() {
    private val destination = MutableStateFlow(Destination.Home)
    val currentDestination = destination.asStateFlow()

    val uiState = combine(destination, settingsRepository.showStatus) { screen, showStatus ->
        LauncherUiState(destination = screen, showStatus = showStatus)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = LauncherUiState(),
    )

    fun openMenu() {
        destination.value = Destination.Menu
    }

    fun returnHomeIfShowingMenu(): Boolean {
        if (destination.value != Destination.Menu) return false
        destination.value = Destination.Home
        return true
    }
}
