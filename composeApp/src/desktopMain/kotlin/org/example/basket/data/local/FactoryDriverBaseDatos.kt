package org.example.basket.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.example.basket.db.ActivoDatabase

actual class FactoryDriverBaseDatos {
    actual fun crearDriver(): SqlDriver {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        ActivoDatabase.Schema.create(driver)
        return driver
    }
}
