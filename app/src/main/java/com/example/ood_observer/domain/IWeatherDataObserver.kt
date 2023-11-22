package com.example.ood_observer.domain

interface IWeatherDataObserver {
    fun update(data: WeatherData)
}