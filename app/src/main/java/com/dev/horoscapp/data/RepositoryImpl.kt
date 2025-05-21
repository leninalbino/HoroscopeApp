package com.dev.horoscapp.data

import android.util.Log
import com.dev.horoscapp.data.network.HoroscopeApiService
import com.dev.horoscapp.domain.Repository
import com.dev.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomainModel() }
            .onFailure { Log.i("Asis", "Ha ocurrido un error: ${it.message}") }
        return null
    }
}