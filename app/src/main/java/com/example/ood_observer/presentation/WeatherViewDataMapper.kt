package com.example.ood_observer.presentation

import com.example.ood_observer.domain.WeatherCode
import com.example.ood_observer.domain.WeatherData
import com.example.ood_observer.domain.WindDirection
import org.threeten.bp.format.TextStyle
import java.util.Locale


class WeatherViewDataMapper {

    fun map(data: WeatherData): WeatherViewData {
        return WeatherViewData(
            temperature = "${data.temperature.asIs.value} ℃",
            temperatureAsFeel = "Ощущается как ${data.temperature.asFeel.value} ℃",
            location = "${data.location.city}, ${data.location.region} ${data.location.country}",
            localizedDescription = data.localizedDescription,
            uvIndex = when (data.uvIndex) {
                in 0..2 -> "Низкий"
                in 3..5 -> "Умеренный"
                in 6..7 -> "Высокий"
                in 8..10 -> "Очень высокий"
                else -> "Экстремальный"
            },
            humidity = "${data.humidity.percent} %",
            pressure = "${data.pressure.hpa} гПа",
            precipitation = "${data.precipitation.mm} мм",
            wind = "${data.wind.speed} км/ч ${
                when (data.wind.direction) {
                    WindDirection.SOUTH -> "южный"
                    WindDirection.NORTH -> "северный"
                    WindDirection.WEST -> "западный"
                    WindDirection.EAST -> "восточный"
                    WindDirection.NORTH_EAST -> "северо-восточный"
                    WindDirection.NORTH_WEST -> "северо-западный"
                    WindDirection.SOUTH_EAST -> "юго-восточный"
                    WindDirection.SOUTH_WEST -> "юго-западный"
                    WindDirection.NORTH_NORTH_EAST -> "северный/северо-восточный"
                    WindDirection.EAST_NORTH_EAST -> "восточный/северо/восточный"
                    WindDirection.EAST_SOUTH_EAST -> "восточный/юго-восточный"
                    WindDirection.SOUTH_SOUTH_EAST -> "южный/юго-восточный"
                    WindDirection.SOUTH_SOUTH_WEST -> "южный/юго-западный"
                    WindDirection.WEST_SOUTH_WEST -> "западный/юго-западный"
                    WindDirection.WEST_NORTH_WEST -> "западный/северо-западный"
                    WindDirection.NORTH_NORTH_WEST -> "северный/северо-западный"
                }
            }",
            weatherIcon = when (data.weatherCode) {
                WeatherCode.SUNNY -> WeatherIcon.SUNNY
                WeatherCode.PARTLY_CLOUDY -> WeatherIcon.PARTLY_CLOUDY
                WeatherCode.CLOUDY,
                WeatherCode.VERY_CLOUDY -> WeatherIcon.CLOUDY

                WeatherCode.FOG -> WeatherIcon.FOG
                WeatherCode.LIGHT_SHOWERS,
                WeatherCode.LIGHT_SLEET_SHOWERS,
                WeatherCode.LIGHT_SLEET,
                WeatherCode.LIGHT_RAIN -> WeatherIcon.LIGHT_RAIN

                WeatherCode.LIGHT_SNOW_SHOWERS,
                WeatherCode.LIGHT_SNOW -> WeatherIcon.LIGHT_SHOW

                WeatherCode.HEAVY_SNOW_SHOWERS,
                WeatherCode.HEAVY_SNOW -> WeatherIcon.HEAVY_SHOW

                WeatherCode.HEAVY_SHOWERS,
                WeatherCode.HEAVY_RAIN -> WeatherIcon.HEAVY_RAIN

                WeatherCode.THUNDERY_HEAVY_RAIN,
                WeatherCode.THUNDERY_SNOW_SHOWERS,
                WeatherCode.THUNDERY_SHOWERS -> WeatherIcon.THUNDERY
            },
            localObservationDateTime = with(data.localObservationDateTime) {
                """
                 Время наблюдения - $dayOfMonth ${
                    month.getDisplayName(
                        TextStyle.FULL,
                        Locale.getDefault()
                    )
                } ${hour}:${minute}
            """.trimIndent()
            }
        )
    }

}