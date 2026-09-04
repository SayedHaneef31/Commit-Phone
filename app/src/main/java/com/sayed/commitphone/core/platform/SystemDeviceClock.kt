package com.sayed.commitphone.core.platform

import java.util.Date
import javax.inject.Inject

class SystemDeviceClock @Inject constructor() : DeviceClock {
    override fun now(): Date = Date()
}
