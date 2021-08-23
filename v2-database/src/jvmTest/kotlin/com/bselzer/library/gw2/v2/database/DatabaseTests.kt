package com.bselzer.library.gw2.v2.database

import kotlin.test.Test
import kotlin.test.assertNotNull

class DatabaseTests
{
    @Test
    fun create()
    {
        val database = Gw2Database(DriverFactory().createDriver())
        assertNotNull(database)
    }
}