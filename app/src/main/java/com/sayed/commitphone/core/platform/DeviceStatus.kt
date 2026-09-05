package com.sayed.commitphone.core.platform

data class DeviceStatus(
    val batteryPercent: Int,
    val isCharging: Boolean,
    val networkLabel: String,
)

interface DeviceStatusProvider {
    fun current(): DeviceStatus
}
