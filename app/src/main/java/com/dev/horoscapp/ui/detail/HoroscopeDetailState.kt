package com.dev.horoscapp.ui.detail

import com.dev.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val prediction: String, val sing:String, val horoscopeModel: HoroscopeModel) : HoroscopeDetailState()

}