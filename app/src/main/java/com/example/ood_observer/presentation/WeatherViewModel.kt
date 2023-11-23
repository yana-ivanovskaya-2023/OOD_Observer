package com.example.ood_observer.presentation

import androidx.lifecycle.ViewModel
import com.example.ood_observer.domain.IWeatherDataObservable
import com.example.ood_observer.domain.IWeatherDataObserver
import com.example.ood_observer.domain.WeatherData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class WeatherViewModel(
    private val weatherDataObservable: IWeatherDataObservable,
    private val dataMapper: WeatherViewDataMapper
) : ViewModel(), IWeatherDataObserver {

    val state get() = mState.asStateFlow()

    private val mState = MutableStateFlow(WeatherViewData.default())

    init {
        weatherDataObservable.register(this)
    }

    override fun update(data: WeatherData) {
        mState.tryEmit(dataMapper.map(data))
    }

    override fun onCleared() {
        weatherDataObservable.unregister(this)
        super.onCleared()
    }

}