package com.sayed.commitphone.feature.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.sayed.commitphone.ui.theme.CommitPhoneTheme
import org.junit.Rule
import org.junit.Test
import java.util.Date

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun homeShowsItsPrimaryMenuEntryPoint() {
        composeTestRule.setContent {
            CommitPhoneTheme {
                HomeScreen(
                    onMenuClick = {},
                    showStatus = true,
                    now = Date(0),
                )
            }
        }

        composeTestRule.onNodeWithText("Commit Phone").assertIsDisplayed()
        composeTestRule.onNodeWithText("Menu").assertIsDisplayed()
    }
}
