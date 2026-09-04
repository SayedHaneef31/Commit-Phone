package com.sayed.commitphone.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val PhoneColorScheme = darkColorScheme(
    primary = PhoneAccent,
    onPrimary = PhoneBlack,
    primaryContainer = PhoneAccentDim,
    onPrimaryContainer = PhoneTextPrimary,
    secondary = PhoneTextSecondary,
    onSecondary = PhoneBlack,
    background = PhoneBlack,
    onBackground = PhoneTextPrimary,
    surface = PhoneSurface,
    onSurface = PhoneTextPrimary,
    surfaceVariant = PhoneSurfaceElevated,
    onSurfaceVariant = PhoneTextSecondary,
    outline = PhoneDivider,
    error = PhoneError,
    onError = PhoneBlack,
)

@Composable
fun CommitPhoneTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PhoneColorScheme,
        typography = Typography,
        content = content,
    )
}
