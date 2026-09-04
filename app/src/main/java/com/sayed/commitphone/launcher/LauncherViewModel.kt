package com.sayed.commitphone.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sayed.commitphone.core.navigation.Destination
import com.sayed.commitphone.core.navigation.DPadDirection
import com.sayed.commitphone.core.navigation.HomeControl
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
    val focusedControl: HomeControl = HomeControl.Menu,
    val lastKeypadInput: String? = null,
)

@HiltViewModel
class LauncherViewModel @Inject constructor(
    settingsRepository: LauncherSettingsRepository,
) : ViewModel() {
    private val destination = MutableStateFlow(Destination.Home)
    private val focusedControl = MutableStateFlow(HomeControl.Menu)
    private val lastKeypadInput = MutableStateFlow<String?>(null)
    val currentDestination = destination.asStateFlow()

    val uiState = combine(
        destination,
        settingsRepository.showStatus,
        focusedControl,
        lastKeypadInput,
    ) { screen, showStatus, focus, keypadInput ->
        LauncherUiState(
            destination = screen,
            showStatus = showStatus,
            focusedControl = focus,
            lastKeypadInput = keypadInput,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = LauncherUiState(),
    )

    fun openMenu() {
        destination.value = Destination.Menu
    }

    fun moveFocus(direction: DPadDirection) {
        focusedControl.value = when (direction) {
            DPadDirection.Up -> when (focusedControl.value) {
                HomeControl.Keypad -> HomeControl.DPad
                HomeControl.DPad -> HomeControl.Menu
                HomeControl.Menu -> HomeControl.Menu
            }
            DPadDirection.Down -> when (focusedControl.value) {
                HomeControl.Menu -> HomeControl.DPad
                HomeControl.DPad -> HomeControl.Keypad
                HomeControl.Keypad -> HomeControl.Keypad
            }
            DPadDirection.Left, DPadDirection.Right -> focusedControl.value
        }
    }

    fun activateFocusedControl() {
        if (focusedControl.value == HomeControl.Menu) openMenu()
    }

    fun onKeypadInput(key: String) {
        focusedControl.value = HomeControl.Keypad
        lastKeypadInput.value = key
    }

    fun returnHomeIfShowingMenu(): Boolean {
        if (destination.value != Destination.Menu) return false
        destination.value = Destination.Home
        return true
    }
}
