package com.example.ood_observer.data.json

import com.google.gson.annotations.SerializedName

data class GeographicAreaJson(
    @SerializedName("areaName")
    val areaName: List<ValueJson>,
    @SerializedName("region")
    val region: List<ValueJson>,
    @SerializedName("country")
    val country: List<ValueJson>
)