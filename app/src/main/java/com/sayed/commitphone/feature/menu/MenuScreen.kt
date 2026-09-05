package com.sayed.commitphone.feature.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.sayed.commitphone.core.navigation.DPadDirection
import com.sayed.commitphone.core.platform.DeviceStatus
import com.sayed.commitphone.feature.home.PhoneControlDeck
import com.sayed.commitphone.ui.PhoneLayout
import com.sayed.commitphone.ui.PhoneScreenFrame

private data class MenuEntry(val label: String, val monogram: String)

private val menuEntries = listOf(
    MenuEntry("Messages", "MSG"),
    MenuEntry("Contacts", "CON"),
    MenuEntry("Call log", "LOG"),
    MenuEntry("Camera", "CAM"),
    MenuEntry("Gallery", "GAL"),
    MenuEntry("Clock", "CLK"),
    MenuEntry("Calendar", "CAL"),
    MenuEntry("Calculator", "123"),
    MenuEntry("Settings", "SET"),
)

@Composable
fun MenuScreen(
    selectedIndex: Int,
    deviceStatus: DeviceStatus = DeviceStatus(0, false, "Offline"),
    lastKeypadInput: String?,
    onDPadDirection: (DPadDirection) -> Unit,
    onDPadCenter: () -> Unit,
    onKeypadInput: (String) -> Unit,
    onItemClick: (Int) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .navigationBarsPadding()
            .padding(
                horizontal = PhoneLayout.horizontalPadding,
                vertical = PhoneLayout.verticalPadding,
            )
            .semantics { contentDescription = "Menu screen" },
        verticalArrangement = Arrangement.spacedBy(PhoneLayout.sectionSpacing),
    ) {
        MenuDisplay(
            selectedIndex = selectedIndex,
            status = deviceStatus,
            onItemClick = onItemClick,
            modifier = Modifier.weight(PhoneLayout.displayWeight),
        )
        PhoneControlDeck(
            dPadFocused = true,
            keypadFocused = false,
            lastKeypadInput = lastKeypadInput,
            onMenuClick = {},
            onBackClick = onBackClick,
            onDPadDirection = onDPadDirection,
            onDPadCenter = onDPadCenter,
            onKeypadInput = onKeypadInput,
            modifier = Modifier.weight(PhoneLayout.controlsWeight),
        )
    }
}

@Composable
private fun LegacyMenuDisplay(
    selectedIndex: Int,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(PhoneLayout.displayCornerRadius),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Column(modifier = Modifier.padding(PhoneLayout.displayPadding)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("|||", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
                Spacer(Modifier.weight(1f))
                Text("Menu", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onSurface)
                Spacer(Modifier.weight(1f))
                Text("100%", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
            }

            Spacer(Modifier.weight(0.35f))

            menuEntries.chunked(3).forEachIndexed { rowIndex, row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    row.forEachIndexed { columnIndex, entry ->
                        val index = rowIndex * 3 + columnIndex
                        MenuTile(
                            entry = entry,
                            selected = index == selectedIndex,
                            onClick = { onItemClick(index) },
                            modifier = Modifier.weight(1f),
                        )
                    }
                }
            }

            Spacer(Modifier.weight(0.15f))
            Text(
                text = "•  ·  ·",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun MenuDisplay(
    selectedIndex: Int,
    status: DeviceStatus,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    PhoneScreenFrame(
        status = status,
        leftSoftKey = "Menu",
        rightSoftKey = "Select",
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                menuEntries.chunked(3).forEachIndexed { rowIndex, row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        row.forEachIndexed { columnIndex, entry ->
                            val index = rowIndex * 3 + columnIndex
                            MenuTile(
                                entry = entry,
                                selected = index == selectedIndex,
                                onClick = { onItemClick(index) },
                                modifier = Modifier.weight(1f),
                            )
                        }
                    }
                }
            }
        },
        modifier = modifier,
    )
}

@Composable
private fun MenuTile(
    entry: MenuEntry,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(if (pressed) 0.97f else 1f, label = "menu tile press")
    val hapticFeedback = LocalHapticFeedback.current
    Column(
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    hapticFeedback.performHapticFeedback(HapticFeedbackType.KeyboardTap)
                    onClick()
                },
            )
            .semantics {
                contentDescription = entry.label
                role = Role.Button
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = if (selected) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface,
            border = BorderStroke(
                width = if (selected) 2.dp else 1.dp,
                color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
            ),
            shadowElevation = if (selected) 5.dp else 2.dp,
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = entry.monogram,
                    color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
        Text(
            text = entry.label,
            color = if (selected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 7.dp),
        )
    }
}
