package com.example.ood_observer.presentation

import androidx.annotation.DrawableRes
import com.example.ood_observer.R

enum class WeatherIcon(@DrawableRes val drawableRes: Int) {
    CLOUDY(R.drawable.cloudy),
    PARTLY_CLOUDY(R.drawable.partly_cloudy),
    SUNNY(R.drawable.sunny),
    FOG(R.drawable.fog),
    HEAVY_RAIN(R.drawable.heavy_rain),
    LIGHT_RAIN(R.drawable.light_rain),
    HEAVY_SHOW(R.drawable.heavy_show),
    LIGHT_SHOW(R.drawable.light_snow),
    THUNDERY(R.drawable.thundery)
}