package com.example.ood_observer.presentation

import androidx.lifecycle.ViewModel
import com.example.ood_observer.domain.IWeatherDataObservable
import com.example.ood_observer.domain.IWeatherDataObserver
import com.example.ood_observer.domain.WeatherData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel(
    private val weatherDataObservable: IWeatherDataObservable
) : ViewModel(), IWeatherDataObserver {

    val state get() = mState.asStateFlow()

    private val mState = MutableStateFlow<WeatherData?>(null)

    init {
        weatherDataObservable.register(this)
    }

    override fun update(data: WeatherData) {
        println(data)
        mState.tryEmit(data)
    }

    override fun onCleared() {
        weatherDataObservable.unregister(this)
        super.onCleared()
    }

}