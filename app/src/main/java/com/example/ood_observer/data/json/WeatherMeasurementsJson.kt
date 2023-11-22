package com.example.ood_observer.data.json

import com.google.gson.annotations.SerializedName

data class WeatherMeasurementsJson(
    @SerializedName("current_condition")
    val currentCondition: List<WeatherConditionJson>,
    @SerializedName("nearest_area")
    val geographicArea: List<GeographicAreaJson>
)