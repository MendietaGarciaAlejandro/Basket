package org.example.basket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.example.basket.data.local.FactoryDriverBaseDatos
import org.example.basket.di.moduloAplicacion
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(moduloAplicacion(FactoryDriverBaseDatos(this@MainActivity).crearDriver()))
        }

        setContent {
            App(
                sqlDriver = TODO()
            )
        }
    }
}
