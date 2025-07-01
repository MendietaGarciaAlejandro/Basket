import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoAssetDto(
    val id: String,
    val symbol: String,
    val name: String,
    @SerialName("current_price")
    val currentPrice: Double,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerialName("high_24h")
    val high24h: Double?,
    @SerialName("low_24h")
    val low24h: Double?,
    @SerialName("market_cap")
    val marketCap: Double?,
    @SerialName("total_volume")
    val volume24h: Double?
)
