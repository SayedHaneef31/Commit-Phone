package com.sayed.commitphone.launcher

import com.sayed.commitphone.core.navigation.Destination
import com.sayed.commitphone.data.settings.LauncherSettingsRepository
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherViewModelTest {
    @Test
    fun `menu navigation always returns to home`() {
        val viewModel = LauncherViewModel(
            object : LauncherSettingsRepository {
                override val showStatus = flowOf(true)
            },
        )

        viewModel.openMenu()
        assertEquals(Destination.Menu, viewModel.currentDestination.value)

        assertEquals(true, viewModel.returnHomeIfShowingMenu())
        assertEquals(Destination.Home, viewModel.currentDestination.value)
    }
}
