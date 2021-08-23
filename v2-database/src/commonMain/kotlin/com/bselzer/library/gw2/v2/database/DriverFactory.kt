package com.bselzer.library.gw2.v2.database

import com.squareup.sqldelight.db.SqlDriver

expect class DriverFactory
{
    fun createDriver(): SqlDriver
}