package com.sayed.commitphone.feature.keypad

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.ui.unit.dp
import com.sayed.commitphone.core.navigation.DPadDirection
import com.sayed.commitphone.ui.theme.PhoneKeyBottom
import com.sayed.commitphone.ui.theme.PhoneKeyTop

@Composable
fun DPad(
    focused: Boolean,
    onDirection: (DPadDirection) -> Unit,
    onCenter: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val hapticFeedback = LocalHapticFeedback.current
    Surface(
        modifier = modifier.size(width = 112.dp, height = 104.dp),
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(
            width = if (focused) 2.dp else 1.dp,
            color = if (focused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
        ),
        shadowElevation = 2.dp,
    ) {
        Box(contentAlignment = Alignment.Center) {
            DirectionControl(
                name = "Up",
                modifier = Modifier.align(Alignment.TopCenter),
            ) { onDirection(DPadDirection.Up) }
            DirectionControl(
                name = "Left",
                modifier = Modifier.align(Alignment.CenterStart),
            ) { onDirection(DPadDirection.Left) }
            DirectionControl(
                name = "Right",
                modifier = Modifier.align(Alignment.CenterEnd),
            ) { onDirection(DPadDirection.Right) }
            DirectionControl(
                name = "Down",
                modifier = Modifier.align(Alignment.BottomCenter),
            ) { onDirection(DPadDirection.Down) }

            Surface(
                modifier = Modifier
                    .size(52.dp)
                    .clickable(onClick = {
                        hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        onCenter()
                    })
                    .semantics {
                        contentDescription = "D-pad OK"
                        role = Role.Button
                    },
                shape = RoundedCornerShape(14.dp),
                color = Color.Transparent,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                shadowElevation = 6.dp,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Brush.verticalGradient(listOf(PhoneKeyTop, PhoneKeyBottom))),
                )
            }
        }
    }
}

@Composable
private fun DirectionControl(
    name: String,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val hapticFeedback = LocalHapticFeedback.current
    val pressColor by animateColorAsState(
        targetValue = if (pressed) {
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.72f)
        } else {
            Color.Transparent
        },
        label = "d-pad press color",
    )

    Surface(
        modifier = modifier
            .size(38.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                    onClick()
                },
            )
            .semantics {
                contentDescription = "D-pad $name"
                role = Role.Button
            },
        shape = RoundedCornerShape(10.dp),
        color = pressColor,
    ) {}
}
