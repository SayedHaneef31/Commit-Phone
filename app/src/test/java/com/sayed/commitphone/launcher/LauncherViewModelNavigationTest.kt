package com.sayed.commitphone.launcher

import com.sayed.commitphone.core.navigation.Destination
import com.sayed.commitphone.data.settings.LauncherSettingsRepository
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class LauncherViewModelNavigationTest {
    private fun createViewModel(showStatus: Boolean = true): LauncherViewModel {
        return LauncherViewModel(
            object : LauncherSettingsRepository {
                override val showStatus = flowOf(showStatus)
            },
        )
    }

    @Test
    fun initialStateIsHome() {
        val viewModel = createViewModel()
        assertEquals(Destination.Home, viewModel.currentDestination.value)
    }

    @Test
    fun openMenuChangesToMenuDestination() {
        val viewModel = createViewModel()
        viewModel.openMenu()
        assertEquals(Destination.Menu, viewModel.currentDestination.value)
    }

    @Test
    fun returnHomeFromMenuReturnsTrue() {
        val viewModel = createViewModel()
        viewModel.openMenu()
        val result = viewModel.returnHomeIfShowingMenu()
        assertEquals(true, result)
        assertEquals(Destination.Home, viewModel.currentDestination.value)
    }

    @Test
    fun returnHomeWhenAlreadyHomeReturnsFalse() {
        val viewModel = createViewModel()
        val result = viewModel.returnHomeIfShowingMenu()
        assertFalse(result)
        assertEquals(Destination.Home, viewModel.currentDestination.value)
    }

    @Test
    fun canNavigateMenuToHomeAndBack() {
        val viewModel = createViewModel()

        viewModel.openMenu()
        assertEquals(Destination.Menu, viewModel.currentDestination.value)

        viewModel.returnHomeIfShowingMenu()
        assertEquals(Destination.Home, viewModel.currentDestination.value)

        viewModel.openMenu()
        assertEquals(Destination.Menu, viewModel.currentDestination.value)
    }
}
