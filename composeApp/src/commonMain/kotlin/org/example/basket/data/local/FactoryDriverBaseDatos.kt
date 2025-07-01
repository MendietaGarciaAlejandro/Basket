package org.example.basket.data.local

import app.cash.sqldelight.db.SqlDriver

expect class FactoryDriverBaseDatos {
    fun crearDriver(): SqlDriver
}
