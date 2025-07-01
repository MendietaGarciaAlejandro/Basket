package org.example.basket.domain.repository

import org.example.basket.domain.model.Activo
import kotlinx.coroutines.flow.Flow

interface RepositorioActivos {
    fun obtenerActivos(): Flow<List<Activo>>
    suspend fun actualizarActivos()
    suspend fun obtenerActivoPorId(id: String): Activo?
    suspend fun alternarFavorito(activoId: String)
    fun obtenerFavoritos(): Flow<List<Activo>>
}
