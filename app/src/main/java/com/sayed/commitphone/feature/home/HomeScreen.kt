package com.sayed.commitphone.feature.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sayed.commitphone.core.navigation.DPadDirection
import com.sayed.commitphone.core.navigation.HomeControl
import com.sayed.commitphone.core.platform.DeviceClock
import com.sayed.commitphone.feature.keypad.DPad
import com.sayed.commitphone.feature.keypad.KeypadPanel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.sayed.commitphone.ui.theme.CommitPhoneTheme

@Composable
fun HomeScreen(
    onMenuClick: () -> Unit,
    showStatus: Boolean,
    clock: DeviceClock? = null,
    focusedControl: HomeControl = HomeControl.Menu,
    lastKeypadInput: String? = null,
    onDPadDirection: (DPadDirection) -> Unit = {},
    onDPadCenter: () -> Unit = onMenuClick,
    onKeypadInput: (String) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var now by remember { mutableStateOf(clock?.now() ?: Date()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .navigationBarsPadding()
            .padding(horizontal = 18.dp, vertical = 12.dp)
            .semantics { contentDescription = "Home screen" },
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        PhoneDisplay(
            now = now,
            showStatus = showStatus,
            menuFocused = focusedControl == HomeControl.Menu,
            lastKeypadInput = lastKeypadInput,
            onMenuClick = onMenuClick,
            modifier = Modifier.weight(0.56f),
        )

        ControlDeck(
            dPadFocused = focusedControl == HomeControl.DPad,
            keypadFocused = focusedControl == HomeControl.Keypad,
            lastKeypadInput = lastKeypadInput,
            onMenuClick = onMenuClick,
            onDPadDirection = onDPadDirection,
            onDPadCenter = onDPadCenter,
            onKeypadInput = onKeypadInput,
            modifier = Modifier.weight(0.44f),
        )
    }
}

@Composable
private fun PhoneDisplay(
    now: Date,
    showStatus: Boolean,
    menuFocused: Boolean,
    lastKeypadInput: String?,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            if (showStatus) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("|||", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "OWN YOUR ATTENTION",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Spacer(Modifier.weight(1f))
                    Text("100%", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
                }
            }

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now),
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Text(
                        text = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(now),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    if (lastKeypadInput != null) {
                        Text(
                            text = lastKeypadInput,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(top = 12.dp),
                        )
                    }
                }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Menu",
                    color = if (menuFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .clickable(onClick = onMenuClick)
                        .semantics {
                            contentDescription = "Open menu"
                            role = Role.Button
                        }
                        .padding(vertical = 4.dp),
                )
                Text(
                    text = "Select",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(vertical = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun ControlDeck(
    dPadFocused: Boolean,
    keypadFocused: Boolean,
    lastKeypadInput: String?,
    onMenuClick: () -> Unit,
    onDPadDirection: (DPadDirection) -> Unit,
    onDPadCenter: () -> Unit,
    onKeypadInput: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().height(96.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SideControls(left = true, onMenuClick = onMenuClick)
            DPad(
                focused = dPadFocused,
                onDirection = onDPadDirection,
                onCenter = onDPadCenter,
            )
            SideControls(left = false, onMenuClick = onMenuClick)
        }
        Spacer(Modifier.height(12.dp))
        KeypadPanel(
            focused = keypadFocused,
            lastInput = lastKeypadInput,
            onKeyPress = onKeypadInput,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun SideControls(left: Boolean, onMenuClick: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        HardwareKey(
            label = if (left) "MENU" else "BACK",
            onClick = if (left) onMenuClick else ({}),
            topRow = true,
        )
        HardwareKey(
            label = if (left) "CALL" else "END",
            onClick = {},
            topRow = false,
        )
    }
}

@Composable
private fun HardwareKey(
    label: String,
    onClick: () -> Unit,
    topRow: Boolean,
) {
    Surface(
        modifier = Modifier
            .size(width = 72.dp, height = 38.dp)
            .clickable(onClick = onClick)
            .semantics {
                contentDescription = label
                role = Role.Button
            },
        shape = RoundedCornerShape(12.dp),
        color = if (topRow) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        shadowElevation = 3.dp,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(label, color = MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CommitPhoneTheme {
        HomeScreen(
            onMenuClick = {},
            showStatus = true
        )
    }
}
