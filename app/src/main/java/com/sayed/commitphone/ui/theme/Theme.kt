package com.sayed.commitphone.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PhoneColorScheme = darkColorScheme(
    primary = Color(0xFFD6E8C3),
    onPrimary = Color(0xFF17210F),
    secondary = Color(0xFFB7CCAA),
    background = Color(0xFF10120E),
    onBackground = Color(0xFFE3E6DC),
    surface = Color(0xFF191C17),
    onSurface = Color(0xFFE3E6DC),
)

@Composable
fun CommitPhoneTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PhoneColorScheme,
        typography = Typography,
        content = content,
    )
}
