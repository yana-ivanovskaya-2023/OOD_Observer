package com.example.ood_observer.data.json

import com.google.gson.annotations.SerializedName


data class WeatherConditionJson(
    @SerializedName("FeelsLikeC")
    val feelsLikeTemperature: String,
    @SerializedName("temp_C")
    val temperature: String,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("lang_ru")
    val localizedDescription: List<ValueJson>,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("windspeedKmph")
    val windSpeed: String,
    @SerializedName("winddir16Point")
    val windDirection: WindDirectionJson,
    @SerializedName("uvIndex")
    val uvIndex: String,
    @SerializedName("precipMM")
    val precipitation: String
)

enum class WindDirectionJson {
    @SerializedName("S")
    SOUTH,

    @SerializedName("N")
    NORTH,

    @SerializedName("W")
    WEST,

    @SerializedName("E")
    EAST,

    @SerializedName("NE")
    NORTH_EAST,

    @SerializedName("NW")
    NORTH_WEST,

    @SerializedName("SE")
    SOUTH_EAST,

    @SerializedName("SW")
    SOUTH_WEST
}