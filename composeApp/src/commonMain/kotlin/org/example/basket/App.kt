package org.example.basket

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import app.cash.sqldelight.db.SqlDriver
import org.example.basket.ui.activos.PantallaActivos
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.example.basket.ui.activos.ActivosViewModel

@Composable
fun App(sqlDriver: SqlDriver) {
    KoinContext {
        MaterialTheme {
            val viewModel = koinInject<ActivosViewModel>()
            PantallaActivos(viewModel = viewModel)
        }
    }
}