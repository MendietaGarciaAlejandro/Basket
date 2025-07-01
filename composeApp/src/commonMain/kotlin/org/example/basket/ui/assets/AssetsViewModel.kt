package org.example.basket.ui.activos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.basket.domain.model.Activo
import org.example.basket.domain.usecase.ObtenerListaActivosUseCase

data class EstadoActivos(
    val activos: List<Activo> = emptyList(),
    val estaCargando: Boolean = false,
    val error: String? = null
)

class ActivosViewModel(
    private val obtenerListaActivosUseCase: ObtenerListaActivosUseCase
) : ViewModel() {
    private val _estado = MutableStateFlow(EstadoActivos())
    val estado: StateFlow<EstadoActivos> = _estado.asStateFlow()

    init {
        cargarActivos()
    }

    private fun cargarActivos() {
        viewModelScope.launch {
            _estado.value = _estado.value.copy(estaCargando = true)
            try {
                obtenerListaActivosUseCase().collect { activos ->
                    _estado.value = EstadoActivos(activos = activos)
                }
            } catch (e: Exception) {
                _estado.value = EstadoActivos(error = e.message ?: "Error desconocido")
            }
        }
    }
}
