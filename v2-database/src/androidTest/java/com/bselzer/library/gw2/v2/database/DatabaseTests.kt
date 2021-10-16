package com.bselzer.library.gw2.v2.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.runner.RunWith
import kotlin.test.Test
import kotlin.test.assertNotNull

@RunWith(AndroidJUnit4::class)
class DatabaseTests
{
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun create()
    {
        val database = Gw2Database(DriverFactory(context).createDriver())
        assertNotNull(database)
    }
}