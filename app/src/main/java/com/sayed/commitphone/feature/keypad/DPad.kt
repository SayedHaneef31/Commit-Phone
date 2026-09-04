package com.sayed.commitphone.feature.keypad

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.sayed.commitphone.core.navigation.DPadDirection

@Composable
fun DPad(
    focused: Boolean,
    onDirection: (DPadDirection) -> Unit,
    onCenter: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.size(width = 82.dp, height = 88.dp),
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
                    .size(46.dp)
                    .clickable(onClick = onCenter)
                    .semantics {
                        contentDescription = "D-pad OK"
                        role = Role.Button
                    },
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                shadowElevation = 3.dp,
            ) {}
        }
    }
}

@Composable
private fun DirectionControl(
    name: String,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(34.dp)
            .clickable(onClick = onClick)
            .semantics {
                contentDescription = "D-pad $name"
                role = Role.Button
            },
    ) {}
}
