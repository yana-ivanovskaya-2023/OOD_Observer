package com.example.ood_observer.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ood_observer.presentation.WeatherViewModel

class WeatherViewModelProvider : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(
            weatherDataObservable = AppDI.weatherDataObservable
        ) as T
    }

}