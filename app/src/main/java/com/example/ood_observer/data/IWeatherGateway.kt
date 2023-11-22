package com.example.ood_observer.data

import com.example.ood_observer.data.base.ApiResult
import com.example.ood_observer.data.json.WeatherMeasurementsJson

interface IWeatherGateway {
    suspend fun getWeatherData() : ApiResult<WeatherMeasurementsJson>
}