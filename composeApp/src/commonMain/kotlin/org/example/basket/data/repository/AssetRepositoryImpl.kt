package org.example.basket.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.example.basket.data.remote.api.CoinGeckoApi
import org.example.basket.db.ActivoEntity
import org.example.basket.db.ActivoQueries
import org.example.basket.domain.model.Activo
import org.example.basket.domain.repository.RepositorioActivos

class ImplementacionRepositorioActivos(
    private val api: CoinGeckoApi,
    private val consultasActivo: ActivoQueries
) : RepositorioActivos {

    override fun obtenerActivos(): Flow<List<Activo>> {
        return consultasActivo.obtenerTodos()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { entidades ->
                entidades.map { it.aModeloDominio() }
            }
    }

    override suspend fun actualizarActivos() {
        val activosRemotos = api.obtenerMercados()
        consultasActivo.transaction {
            consultasActivo.borrarTodos()
            activosRemotos.forEach { dto ->
                consultasActivo.insertarActivo(
                    id = dto.id,
                    simbolo = dto.simbolo,
                    nombre = dto.nombre,
                    precio_actual = dto.precioActual,
                    cambio_porcentaje_24h = dto.cambioPorcentaje24h,
                    maximo_24h = dto.maximo24h,
                    minimo_24h = dto.minimo24h,
                    capitalizacion_mercado = dto.capitalizacionMercado,
                    volumen_24h = dto.volumen24h,
                    es_favorito = false
                )
            }
        }
    }

    override suspend fun obtenerActivoPorId(id: String): Activo? {
        return consultasActivo.obtenerPorId(id)
            .executeAsOneOrNull()
            ?.aModeloDominio()
    }

    override suspend fun alternarFavorito(activoId: String) {
        val activo = obtenerActivoPorId(activoId) ?: return
        consultasActivo.actualizarFavorito(!activo.esFavorito, activoId)
    }

    override fun obtenerFavoritos(): Flow<List<Activo>> {
        return consultasActivo.obtenerFavoritos()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { entidades ->
                entidades.map { it.aModeloDominio() }
            }
    }
}

private fun ActivoEntity.aModeloDominio() = Activo(
    id = id,
    simbolo = simbolo,
    nombre = nombre,
    precioActual = precio_actual,
    cambioPorcentaje24h = cambio_porcentaje_24h,
    maximo24h = maximo_24h,
    minimo24h = minimo_24h,
    capitalizacionMercado = capitalizacion_mercado,
    volumen24h = volumen_24h,
    esFavorito = es_favorito
)
