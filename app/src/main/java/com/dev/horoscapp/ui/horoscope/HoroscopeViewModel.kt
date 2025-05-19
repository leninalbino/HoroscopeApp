package com.dev.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.dev.horoscapp.data.providers.HoroscopeProvider
import com.dev.horoscapp.domain.model.HoroscopeInfo
import com.dev.horoscapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider):ViewModel() {
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        // This function is used to get the list of horoscopes from the provider
        _horoscope.value = horoscopeProvider.getHoroscopes()

        /*_horoscope.value = listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
         */
    }
}