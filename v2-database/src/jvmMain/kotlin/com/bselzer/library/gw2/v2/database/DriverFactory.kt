package com.bselzer.library.gw2.v2.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

actual class DriverFactory
{
    actual fun createDriver(): SqlDriver
    {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        Gw2Database.Schema.create(driver)
        return driver
    }
}