package com.sayed.commitphone.core.platform

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.BatteryManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SystemDeviceStatusProvider @Inject constructor(
    @ApplicationContext private val context: Context,
) : DeviceStatusProvider {
    override fun current(): DeviceStatus {
        val batteryManager = context.getSystemService(BatteryManager::class.java)
        val battery = batteryManager?.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            ?.coerceIn(0, 100)
            ?: 0
        val charging = batteryManager?.isCharging == true

        val capabilities = runCatching {
            val connectivity = context.getSystemService(ConnectivityManager::class.java)
            connectivity?.getNetworkCapabilities(connectivity.activeNetwork)
        }.getOrNull()
        val network = when {
            capabilities == null -> "Offline"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "Wi-Fi"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Mobile"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> "Ethernet"
            else -> "Connected"
        }

        return DeviceStatus(
            batteryPercent = battery,
            isCharging = charging,
            networkLabel = network,
        )
    }
}
