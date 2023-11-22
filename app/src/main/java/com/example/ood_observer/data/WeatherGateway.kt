package com.example.ood_observer.data

import com.example.ood_observer.data.base.ApiResult
import com.example.ood_observer.data.base.IJsonApi
import com.example.ood_observer.data.json.WeatherMeasurementsJson
import com.example.ood_observer.domain.Degrees
import com.example.ood_observer.domain.IWeatherDataObservable

class WeatherGateway(
    private val api: IJsonApi
) : IWeatherGateway {

    override suspend fun getWeatherData(): ApiResult<WeatherMeasurementsJson> {
        return api.get(
            resultClass = WeatherMeasurementsJson::class.java,
            path = "https://wttr.in/Yoshkar-Ola?format=j1&lang=ru"
        )
    }

}






