package com.sayed.commitphone.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
    onMenuClick: () -> Unit,
    showStatus: Boolean,
    now: Date = Date(),
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .semantics { testTag = "home_screen" },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now),
            style = MaterialTheme.typography.displayLarge,
        )
        Text(
            text = SimpleDateFormat("EEEE, d MMMM", Locale.getDefault()).format(now),
            style = MaterialTheme.typography.titleMedium,
        )
        if (showStatus) {
            Text(
                text = "Home ready",
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.labelLarge,
            )
        }
        Text(
            text = "Commit Phone",
            modifier = Modifier.padding(top = 48.dp),
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = "Your phone, on your terms.",
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodyLarge,
        )
        Button(
            onClick = onMenuClick,
            modifier = Modifier.padding(top = 32.dp),
        ) {
            Text("Menu")
        }
    }
}
