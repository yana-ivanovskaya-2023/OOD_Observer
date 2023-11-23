package com.example.ood_observer.data.json

import com.google.gson.annotations.SerializedName


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
    SOUTH_WEST,

    @SerializedName("NNE")
    NORTH_NORTH_EAST,

    @SerializedName("ENE")
    EAST_NORTH_EAST,

    @SerializedName("ESE")
    EAST_SOUTH_EAST,

    @SerializedName("SSE")
    SOUTH_SOUTH_EAST,

    @SerializedName("SSW")
    SOUTH_SOUTH_WEST,

    @SerializedName("WSW")
    WEST_SOUTH_WEST,

    @SerializedName("WNW")
    WEST_NORTH_WEST,

    @SerializedName("NNW")
    NORTH_NORTH_WEST

}