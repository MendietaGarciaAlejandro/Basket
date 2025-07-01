package org.example.basket.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.example.basket.domain.model.Activo
import org.example.basket.domain.repository.RepositorioActivos

class GetAssetsListUseCase(
    private val repository: RepositorioActivos
) {
    operator fun invoke(): Flow<List<Activo>> = repository.obtenerActivos()
}
