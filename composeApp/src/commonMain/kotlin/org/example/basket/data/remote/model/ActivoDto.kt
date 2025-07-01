package org.example.basket.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActivoDto(
    val id: String,
    val symbol: String,
    @SerialName("name")
    val nombre: String,
    @SerialName("current_price")
    val precioActual: Double,
    @SerialName("price_change_percentage_24h")
    val cambioPorcentaje24h: Double,
    @SerialName("high_24h")
    val maximo24h: Double?,
    @SerialName("low_24h")
    val minimo24h: Double?,
    @SerialName("market_cap")
    val capitalizacionMercado: Double?,
    @SerialName("total_volume")
    val volumen24h: Double?
)
