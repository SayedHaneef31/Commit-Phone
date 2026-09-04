package com.sayed.commitphone

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LauncherRegistrationTest {
    @Test
    fun packageRegistersAHomeActivity() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val homeIntent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME)
        val matches = context.packageManager.queryIntentActivities(homeIntent, 0)

        assertTrue(matches.any { it.activityInfo.packageName == context.packageName })
    }
}
