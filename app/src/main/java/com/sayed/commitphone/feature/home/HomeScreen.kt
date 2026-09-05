package com.sayed.commitphone.feature.home

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.sayed.commitphone.ui.theme.PhoneKeyBottom
import com.sayed.commitphone.ui.theme.PhoneKeyTop
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
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.animation.core.animateFloatAsState
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
import com.sayed.commitphone.ui.PhoneLayout
import com.sayed.commitphone.ui.PhoneScreenFrame
import com.sayed.commitphone.core.platform.DeviceStatus

@Composable
fun HomeScreen(
    onMenuClick: () -> Unit,
    showStatus: Boolean,
    deviceStatus: DeviceStatus = DeviceStatus(0, false, "Offline"),
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
            .padding(
                horizontal = PhoneLayout.horizontalPadding,
                vertical = PhoneLayout.verticalPadding,
            )
            .semantics { contentDescription = "Home screen" },
        verticalArrangement = Arrangement.spacedBy(PhoneLayout.sectionSpacing),
    ) {
        PhoneDisplay(
            now = now,
            showStatus = showStatus,
            status = deviceStatus,
            lastKeypadInput = lastKeypadInput,
            modifier = Modifier.weight(PhoneLayout.displayWeight),
        )

        PhoneControlDeck(
            dPadFocused = focusedControl == HomeControl.DPad,
            keypadFocused = focusedControl == HomeControl.Keypad,
            lastKeypadInput = lastKeypadInput,
            onMenuClick = onMenuClick,
            onBackClick = {},
            onDPadDirection = onDPadDirection,
            onDPadCenter = onDPadCenter,
            onKeypadInput = onKeypadInput,
            modifier = Modifier.weight(PhoneLayout.controlsWeight),
        )
    }
}

@Composable
private fun LegacyPhoneDisplay(
    now: Date,
    showStatus: Boolean,
    menuFocused: Boolean,
    lastKeypadInput: String?,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(PhoneLayout.displayCornerRadius),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Column(modifier = Modifier.padding(PhoneLayout.displayPadding)) {
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

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.TopCenter) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 56.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(now),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
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
                    text = "Back",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(vertical = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun PhoneDisplay(
    now: Date,
    showStatus: Boolean,
    status: DeviceStatus,
    lastKeypadInput: String?,
    modifier: Modifier = Modifier,
) {
    PhoneScreenFrame(
        status = status,
        showStatus = showStatus,
        leftSoftKey = "Menu",
        rightSoftKey = "Back",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(now),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
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
        },
        modifier = modifier,
    )
}

@Composable
fun PhoneControlDeck(
    dPadFocused: Boolean,
    keypadFocused: Boolean,
    lastKeypadInput: String?,
    onMenuClick: () -> Unit,
    onBackClick: () -> Unit,
    onDPadDirection: (DPadDirection) -> Unit,
    onDPadCenter: () -> Unit,
    onKeypadInput: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().height(120.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SideControls(
                lowerSymbol = HardwareSymbol.Call,
                onTopClick = onMenuClick,
                onBottomClick = {},
            )
            DPad(
                focused = dPadFocused,
                onDirection = onDPadDirection,
                onCenter = onDPadCenter,
            )
            SideControls(
                lowerSymbol = HardwareSymbol.End,
                onTopClick = onBackClick,
                onBottomClick = onBackClick,
            )
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
private fun SideControls(
    lowerSymbol: HardwareSymbol,
    onTopClick: () -> Unit,
    onBottomClick: () -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        HardwareKey(
            symbol = HardwareSymbol.SoftKey,
            onClick = onTopClick,
        )
        HardwareKey(
            symbol = lowerSymbol,
            onClick = onBottomClick,
        )
    }
}

private enum class HardwareSymbol {
    SoftKey,
    Call,
    End,
}

@Composable
private fun HardwareKey(
    symbol: HardwareSymbol,
    onClick: () -> Unit,
) {
    val symbolColor = MaterialTheme.colorScheme.onSurface
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(if (pressed) 0.96f else 1f, label = "hardware key press")
    val hapticFeedback = LocalHapticFeedback.current
    Surface(
        modifier = Modifier
            .size(width = 80.dp, height = 42.dp)
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
                contentDescription = symbol.name
                role = Role.Button
            },
        shape = RoundedCornerShape(12.dp),
        color = Color.Transparent,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        shadowElevation = 10.dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(PhoneKeyTop, PhoneKeyBottom))),
            contentAlignment = Alignment.Center,
        ) {
            Canvas(modifier = Modifier.size(width = 30.dp, height = 22.dp)) {
                when (symbol) {
                    HardwareSymbol.SoftKey -> drawSoftKey(symbolColor)
                    HardwareSymbol.Call -> drawIcon(CALL_ICON, symbolColor)
                    HardwareSymbol.End -> drawIcon(END_ICON, symbolColor)
                }
            }
        }
    }
}

private fun DrawScope.drawSoftKey(color: Color) {
    val sw = 2.5.dp.toPx()
    val y = center.y
    val left = size.width * 0.22f
    val right = size.width * 0.78f
    drawLine(color, Offset(left, y), Offset(right, y), sw, StrokeCap.Round)
}

private const val CALL_ICON = "M6.62,10.79c1.44,2.83,3.76,5.14,6.59,6.59l2.2,-2.2c0.27,-0.27,0.67,-0.36,1.02,-0.24c1.12,0.37,2.33,0.57,3.57,0.57c0.55,0,1,0.45,1,1V20c0,0.55,-0.45,1,-1,1c-9.39,0,-17,-7.61,-17,-17c0,-0.55,0.45,-1,1,-1h3.5c0.55,0,1,0.45,1,1c0,1.25,0.2,2.45,0.57,3.57c0.11,0.35,0.03,0.74,-0.25,1.02l-2.2,2.2z"

private const val END_ICON = "M12,9c-1.6,0,-3.15,0.25,-4.6,0.72v3.1c0,0.39,-0.23,0.74,-0.56,0.9c-0.98,0.49,-1.87,1.12,-2.66,1.85c-0.18,0.18,-0.43,0.28,-0.7,0.28c-0.28,0,-0.53,-0.11,-0.71,-0.29L0.29,13.08c-0.18,-0.17,-0.29,-0.42,-0.29,-0.7c0,-0.28,0.11,-0.53,0.29,-0.71C3.34,8.78,7.46,7,12,7s8.66,1.78,11.71,4.67c0.18,0.18,0.29,0.43,0.29,0.71c0,0.28,-0.11,0.53,-0.29,0.7l-2.48,2.48c-0.18,0.18,-0.43,0.29,-0.71,0.29c-0.27,0,-0.52,-0.11,-0.7,-0.28c-0.79,-0.74,-1.69,-1.36,-2.67,-1.85c-0.33,-0.16,-0.56,-0.5,-0.56,-0.9v-3.1C15.15,9.25,13.6,9,12,9z"

private fun DrawScope.drawIcon(pathData: String, color: Color) {
    val path = PathParser().parsePathString(pathData).toPath()
    val s = minOf(size.width, size.height) / 24f
    val tx = (size.width - 24f * s) / 2f
    val ty = (size.height - 24f * s) / 2f
    withTransform(
        transformBlock = {
            translate(left = tx, top = ty)
            scale(scaleX = s, scaleY = s, pivot = Offset.Zero)
        },
        drawBlock = {
            drawPath(path, color)
        },
    )
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
