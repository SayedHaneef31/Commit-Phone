package com.sayed.commitphone.core.platform

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Date

class DeviceClockTest {
    @Test
    fun systemClockReturnsCurrentTime() {
        val clock: DeviceClock = SystemDeviceClock()
        val before = Date()
        val now = clock.now()
        val after = Date()

        assertNotNull(now)
        assertTrue(!now.before(before) && !now.after(after))
    }
}
