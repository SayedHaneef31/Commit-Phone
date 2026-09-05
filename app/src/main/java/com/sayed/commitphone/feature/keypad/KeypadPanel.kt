package com.sayed.commitphone.feature.keypad

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sayed.commitphone.ui.theme.PhoneKeyBottom
import com.sayed.commitphone.ui.theme.PhoneKeyPressed
import com.sayed.commitphone.ui.theme.PhoneKeyTop

private data class KeySpec(val number: String, val letters: String)

private val keypadRows = listOf(
    listOf(KeySpec("1", ""), KeySpec("2", "ABC"), KeySpec("3", "DEF")),
    listOf(KeySpec("4", "GHI"), KeySpec("5", "JKL"), KeySpec("6", "MNO")),
    listOf(KeySpec("7", "PQRS"), KeySpec("8", "TUV"), KeySpec("9", "WXYZ")),
    listOf(KeySpec("*", ""), KeySpec("0", "+"), KeySpec("#", "")),
)

@Composable
fun KeypadPanel(
    focused: Boolean,
    lastInput: String?,
    onKeyPress: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val hapticFeedback = LocalHapticFeedback.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 7.dp)
            .semantics { contentDescription = "Keypad" },
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        keypadRows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                row.forEach { key ->
                    KeypadKey(
                        number = key.number,
                        letters = key.letters,
                        pressed = focused && key.number == lastInput,
                        onClick = {
                            hapticFeedback.performHapticFeedback(HapticFeedbackType.KeyboardTap)
                            onKeyPress(key.number)
                        },
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun KeypadKey(
    number: String,
    letters: String,
    pressed: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxHeight()
            .clickable(onClick = onClick)
            .semantics {
                contentDescription = "Key $number"
                role = Role.Button
            },
        shape = RoundedCornerShape(16.dp),
        color = Color.Transparent,
        border = BorderStroke(
            width = if (pressed) 2.dp else 1.dp,
            color = if (pressed) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline
            },
        ),
        shadowElevation = if (pressed) 1.dp else 11.dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (pressed) {
                        Brush.verticalGradient(listOf(PhoneKeyPressed, PhoneKeyPressed))
                    } else {
                        Brush.verticalGradient(listOf(PhoneKeyTop, PhoneKeyBottom))
                    },
                ),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = number,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                )
                if (letters.isNotEmpty()) {
                    Text(
                        text = letters,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
