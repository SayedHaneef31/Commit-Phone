package com.sayed.commitphone.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sayed.commitphone.core.platform.DeviceStatus

@Composable
fun PhoneScreenFrame(
    status: DeviceStatus,
    showStatus: Boolean = true,
    leftSoftKey: String,
    rightSoftKey: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(PhoneLayout.displayCornerRadius),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Column(modifier = Modifier.padding(PhoneLayout.displayPadding)) {
            if (showStatus) Row(verticalAlignment = Alignment.CenterVertically) {
                Text("|||", style = MaterialTheme.typography.labelSmall)
                Spacer(Modifier.weight(1f))
                Text(
                    text = status.networkLabel,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = buildString {
                        append(status.batteryPercent)
                        append('%')
                        if (status.isCharging) append(" +")
                    },
                    style = MaterialTheme.typography.labelSmall,
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                content()
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(leftSoftKey, style = MaterialTheme.typography.labelLarge)
                Text(
                    rightSoftKey,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}
