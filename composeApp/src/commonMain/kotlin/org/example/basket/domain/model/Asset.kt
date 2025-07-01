package org.example.basket.domain.model

data class Activo(
    val id: String,
    val simbolo: String,
    val nombre: String,
    val precioActual: Double,
    val cambioPorcentaje24h: Double,
    val maximo24h: Double?,
    val minimo24h: Double?,
    val capitalizacionMercado: Double?,
    val volumen24h: Double?,
    val esFavorito: Boolean = false
)
