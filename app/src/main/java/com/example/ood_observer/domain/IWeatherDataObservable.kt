package com.example.ood_observer.domain

interface IWeatherDataObservable {
    fun register(observer: IWeatherDataObserver)
    fun unregister(observer: IWeatherDataObserver)
}