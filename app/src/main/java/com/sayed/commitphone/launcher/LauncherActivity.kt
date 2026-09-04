package com.sayed.commitphone.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sayed.commitphone.core.navigation.Destination
import com.sayed.commitphone.feature.home.HomeScreen
import com.sayed.commitphone.feature.menu.MenuScreen
import com.sayed.commitphone.ui.theme.CommitPhoneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    private val viewModel: LauncherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            CommitPhoneTheme {
                when (uiState.destination) {
                    Destination.Home -> HomeScreen(
                        onMenuClick = viewModel::openMenu,
                        showStatus = uiState.showStatus,
                        focusedControl = uiState.focusedControl,
                        lastKeypadInput = uiState.lastKeypadInput,
                        onDPadDirection = viewModel::moveFocus,
                        onDPadCenter = viewModel::activateFocusedControl,
                        onKeypadInput = viewModel::onKeypadInput,
                    )
                    Destination.Menu -> MenuScreen(onBackClick = viewModel::returnHomeIfShowingMenu)
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!viewModel.returnHomeIfShowingMenu()) {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }
}
