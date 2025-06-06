package com.dev.horoscapp.data.network.response

import com.dev.horoscapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
){
    fun toDomainModel(): PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}