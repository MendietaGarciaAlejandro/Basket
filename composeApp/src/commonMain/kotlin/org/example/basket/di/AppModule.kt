package org.example.basket.di

import app.cash.sqldelight.db.SqlDriver
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.basket.data.remote.api.CoinGeckoApi
import org.example.basket.data.repository.ImplementacionRepositorioActivos
import org.example.basket.domain.repository.RepositorioActivos
import org.example.basket.domain.usecase.ObtenerListaActivosUseCase
import org.example.basket.ui.activos.ActivosViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun moduloAplicacion(sqlDriver: SqlDriver) = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }
    }

    single { ActivoDatabase(sqlDriver) }
    single { get<ActivoDatabase>().activoQueries }
    single { CoinGeckoApi(get()) }
    single<RepositorioActivos> { ImplementacionRepositorioActivos(get(), get()) }
    single { ObtenerListaActivosUseCase(get()) }

    factory { ActivosViewModel(get()) }
}
