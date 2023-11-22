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
    SOUTH_WEST
}