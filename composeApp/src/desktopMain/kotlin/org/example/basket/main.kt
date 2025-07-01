package org.example.basket

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Basket",
    ) {
        App(
            sqlDriver = TODO()
        )
    }
}