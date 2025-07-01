package org.example.basket.domain.usecase

import org.example.basket.domain.repository.RepositorioActivos
import org.example.basket.domain.model.Activo
import kotlinx.coroutines.flow.Flow

class ObtenerListaActivosUseCase(
    private val repositorio: RepositorioActivos
) {
    operator fun invoke(): Flow<List<Activo>> = repositorio.obtenerActivos()
}
