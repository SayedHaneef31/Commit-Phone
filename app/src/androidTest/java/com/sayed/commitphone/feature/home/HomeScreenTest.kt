package com.sayed.commitphone.feature.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.sayed.commitphone.ui.theme.CommitPhoneTheme
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun homeScreenDisplaysCoreElements() {
        composeTestRule.setContent {
            CommitPhoneTheme {
                HomeScreen(
                    onMenuClick = {},
                    showStatus = true,
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Home screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Commit Phone").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Open menu").assertIsDisplayed()
    }

    @Test
    fun homeScreenHidesStatusWhenDisabled() {
        composeTestRule.setContent {
            CommitPhoneTheme {
                HomeScreen(
                    onMenuClick = {},
                    showStatus = false,
                )
            }
        }

        composeTestRule.onNodeWithText("Commit Phone").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Open menu").assertIsDisplayed()
    }
}
