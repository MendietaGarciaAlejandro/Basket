package org.example.basket.ui.activos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.basket.domain.model.Activo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaActivos(
    viewModel: ActivosViewModel
) {
    val estado by viewModel.estado.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Basket - Activos Financieros") }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when {
                estado.estaCargando -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                estado.error != null -> {
                    Text(
                        text = estado.error ?: "",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {
                    ListaActivos(activos = estado.activos)
                }
            }
        }
    }
}

@Composable
private fun ListaActivos(
    activos: List<Activo>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(activos) { activo ->
            ItemActivo(activo = activo)
        }
    }
}

@Composable
private fun ItemActivo(
    activo: Activo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = activo.simbolo.uppercase(),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = activo.nombre,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "$${activo.precioActual}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${activo.cambioPorcentaje24h}%",
                    color = if (activo.cambioPorcentaje24h >= 0)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
