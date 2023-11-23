package com.example.ood_observer.presentation

data class WeatherViewData(
    val temperature: String,
    val temperatureAsFeel: String,
    val location: String,
    val humidity: String,
    val pressure: String,
    val wind: String,
    val uvIndex: String,
    val precipitation: String,
    val localizedDescription: String,
    val localObservationDateTime: String,
    val weatherIcon: WeatherIcon
) {
    companion object {
        fun default() = WeatherViewData(
            temperature = "- ℃",
            temperatureAsFeel = "Ощущается как - ℃",
            location = "_",
            localizedDescription = "-",
            uvIndex = "-",
            humidity = "- %",
            pressure = "- гПа",
            precipitation = "- мм",
            wind = "- км/ч -",
            weatherIcon = WeatherIcon.CLOUDY,
            localObservationDateTime = "Время наблюдения -"
        )
    }

}