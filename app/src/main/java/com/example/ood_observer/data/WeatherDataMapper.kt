package com.example.ood_observer.data

import com.example.ood_observer.data.json.WeatherMeasurementsJson
import com.example.ood_observer.domain.Degrees
import com.example.ood_observer.domain.Humidity
import com.example.ood_observer.domain.Location
import com.example.ood_observer.domain.Precipitation
import com.example.ood_observer.domain.Pressure
import com.example.ood_observer.domain.Temperature
import com.example.ood_observer.domain.WeatherCode
import com.example.ood_observer.domain.WeatherData
import com.example.ood_observer.domain.Wind
import com.example.ood_observer.domain.WindDirection
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale


class WeatherDataMapper {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-M-dd hh:mm a", Locale.ENGLISH)

    fun map(json: WeatherMeasurementsJson): WeatherData = with(json) {

        val condition = currentCondition.first()
        val area = geographicArea.first()

        val temperature = Temperature(
            asIs = condition.temperature.toIntOrNull()
                ?.let { Degrees(it) } ?: Degrees(Int.MAX_VALUE),
            asFeel = condition.feelsLikeTemperature.toIntOrNull()
                ?.let { Degrees(it) } ?: Degrees(Int.MAX_VALUE),
        )
        val location = Location(
            city = area.areaName.first().value,
            region = area.region.first().value,
            country = area.country.first().value
        )
        return WeatherData(
            temperature = temperature,
            humidity = Humidity(condition.humidity.toIntOrNull() ?: 0),
            localizedDescription = condition.localizedDescription.first().value,
            location = location,
            precipitation = Precipitation(condition.precipitation.toIntOrNull() ?: 0),
            pressure = Pressure(condition.pressure.toIntOrNull() ?: 0),
            uvIndex = condition.uvIndex.toIntOrNull() ?: 0,
            wind = Wind(
                speed = condition.windSpeed.toIntOrNull() ?: 0,
                direction = WindDirection.valueOf(condition.windDirection.name)
            ),
            localObservationDateTime = LocalDateTime.parse(condition.observationTime, formatter),
            weatherCode = WeatherCode.values().firstOrNull {
                it.codes.contains(condition.weatherCode.toIntOrNull() ?: 0)
            } ?: WeatherCode.PARTLY_CLOUDY
        )
    }

}