package com.example.ood_observer.domain

import org.threeten.bp.ZonedDateTime


data class WeatherData(
    val temperature: Temperature,
    val location: Location,
    val humidity: Humidity,
    val pressure: Pressure,
    val wind: Wind,
    val uvIndex: Int,
    val precipitation: Precipitation,
    val localizedDescription: String,
    val localObservationDateTime: ZonedDateTime,
    val weatherCode: WeatherCode
)