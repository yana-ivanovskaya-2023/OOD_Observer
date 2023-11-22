package com.example.ood_observer.domain


data class Wind(
    val speed: Int,
    val direction: WindDirection
)

enum class WindDirection {
    SOUTH,
    NORTH,
    WEST,
    EAST,
    NORTH_EAST,
    NORTH_WEST,
    SOUTH_EAST,
    SOUTH_WEST
}