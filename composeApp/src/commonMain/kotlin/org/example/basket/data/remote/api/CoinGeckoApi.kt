package org.example.basket.data.remote.api

import CoinGeckoAssetDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class CoinGeckoApi(
    private val client: HttpClient
) {
    suspend fun getMarkets(
        vsCurrency: String = "usd",
        order: String = "market_cap_desc",
        perPage: Int = 100,
        page: Int = 1
    ): List<CoinGeckoAssetDto> {
        return client.get("https://api.coingecko.com/api/v3/coins/markets") {
            parameter("vs_currency", vsCurrency)
            parameter("order", order)
            parameter("per_page", perPage)
            parameter("page", page)
            parameter("sparkline", false)
        }.body()
    }
}
