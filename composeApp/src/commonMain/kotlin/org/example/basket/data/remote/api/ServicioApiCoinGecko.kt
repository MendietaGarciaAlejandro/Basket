package org.example.basket.data.remote.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.call.*
import org.example.basket.data.remote.model.ActivoDto

class ServicioApiCoinGecko(
    private val cliente: HttpClient
) {
    suspend fun obtenerMercados(
        monedaBase: String = "usd",
        orden: String = "market_cap_desc",
        porPagina: Int = 100,
        pagina: Int = 1
    ): List<ActivoDto> {
        return cliente.get("https://api.coingecko.com/api/v3/coins/markets") {
            parameter("vs_currency", monedaBase)
            parameter("order", orden)
            parameter("per_page", porPagina)
            parameter("page", pagina)
            parameter("sparkline", false)
        }.body()
    }
}
