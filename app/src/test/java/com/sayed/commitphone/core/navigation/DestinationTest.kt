package com.sayed.commitphone.core.navigation

import org.junit.Assert.assertEquals
import org.junit.Test

class DestinationTest {
    @Test
    fun homeDestinationExists() {
        assertEquals(Destination.Home, Destination.valueOf("Home"))
    }

    @Test
    fun menuDestinationExists() {
        assertEquals(Destination.Menu, Destination.valueOf("Menu"))
    }

    @Test
    fun allDestinationsAreDefined() {
        assertEquals(2, Destination.entries.size)
    }
}
