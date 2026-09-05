package com.sayed.commitphone.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sayed.commitphone.core.navigation.Destination
import com.sayed.commitphone.core.navigation.DPadDirection
import com.sayed.commitphone.core.navigation.HomeControl
import com.sayed.commitphone.core.platform.DeviceStatus
import com.sayed.commitphone.core.platform.DeviceStatusProvider
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
    val selectedMenuIndex: Int = 0,
    val deviceStatus: DeviceStatus = DeviceStatus(0, false, "Offline"),
)

@HiltViewModel
class LauncherViewModel @Inject constructor(
    settingsRepository: LauncherSettingsRepository,
    private val deviceStatusProvider: DeviceStatusProvider,
) : ViewModel() {
    private val destination = MutableStateFlow(Destination.Home)
    private val focusedControl = MutableStateFlow(HomeControl.Menu)
    private val lastKeypadInput = MutableStateFlow<String?>(null)
    private val selectedMenuIndex = MutableStateFlow(0)
    private val deviceStatus = MutableStateFlow(deviceStatusProvider.current())
    val currentDestination = destination.asStateFlow()

    private val baseUiState = combine(
        destination,
        settingsRepository.showStatus,
        focusedControl,
        lastKeypadInput,
        selectedMenuIndex,
    ) { screen, showStatus, focus, keypadInput, menuIndex ->
        LauncherUiState(
            destination = screen,
            showStatus = showStatus,
            focusedControl = focus,
            lastKeypadInput = keypadInput,
            selectedMenuIndex = menuIndex,
        )
    }

    val uiState = combine(baseUiState, deviceStatus) { state, status ->
        state.copy(deviceStatus = status)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = LauncherUiState(),
    )

    fun openMenu() {
        destination.value = Destination.Menu
    }

    fun refreshDeviceStatus() {
        deviceStatus.value = deviceStatusProvider.current()
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

    fun moveMenuSelection(direction: DPadDirection) {
        val index = selectedMenuIndex.value
        selectedMenuIndex.value = when (direction) {
            DPadDirection.Up -> if (index >= MENU_COLUMNS) index - MENU_COLUMNS else index
            DPadDirection.Down -> if (index + MENU_COLUMNS < MENU_ITEM_COUNT) index + MENU_COLUMNS else index
            DPadDirection.Left -> if (index % MENU_COLUMNS > 0) index - 1 else index
            DPadDirection.Right -> if (index % MENU_COLUMNS < MENU_COLUMNS - 1) index + 1 else index
        }
    }

    fun selectMenuItem(index: Int) {
        if (index in 0 until MENU_ITEM_COUNT) selectedMenuIndex.value = index
    }

    fun onMenuKeypadInput(key: String) {
        lastKeypadInput.value = key
        key.toIntOrNull()?.takeIf { it in 1..MENU_ITEM_COUNT }?.let { number ->
            selectedMenuIndex.value = number - 1
        }
    }

    fun returnHomeIfShowingMenu(): Boolean {
        if (destination.value != Destination.Menu) return false
        destination.value = Destination.Home
        return true
    }

    private companion object {
        const val MENU_COLUMNS = 3
        const val MENU_ITEM_COUNT = 9
    }
}
