package org.example.basket.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.example.basket.db.ActivoDatabase

actual class FactoryDriverBaseDatos(private val contexto: Context) {
    actual fun crearDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = ActivoDatabase.Schema,
            context = contexto,
            name = "basket.db"
        )
    }
}
