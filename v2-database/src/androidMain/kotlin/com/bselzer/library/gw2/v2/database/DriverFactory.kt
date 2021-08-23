package com.bselzer.library.gw2.v2.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context)
{
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(Gw2Database.Schema, context, "Gw2Database")
}