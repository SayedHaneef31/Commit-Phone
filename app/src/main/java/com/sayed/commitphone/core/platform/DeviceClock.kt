package com.sayed.commitphone.core.platform

import java.util.Date

fun interface DeviceClock {
    fun now(): Date
}
