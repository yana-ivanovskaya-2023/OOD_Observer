package com.example.ood_observer.domain

enum class WeatherCode(vararg val codes: Int, val icon: String) {

    UNKNOWN(0, icon = "✨"),
    SUNNY(113, icon = "☀️"),

    PARTLY_CLOUDY(116, icon = "⛅️"),
    CLOUDY(119, icon = "☁️"),
    VERY_CLOUDY(122, icon = "☁️"),
    FOG(143, 248, 260, icon = "\uD83C\uDF2B"),
    LIGHT_SHOWERS(176, 263, 353, icon = "\uD83C\uDF26"),
    LIGHT_SLEET_SHOWERS(179, 362, 365, 374, icon = "\uD83C\uDF27"),

    LIGHT_SLEET(182, 185, 281, 284, 311, 314, 317, 350, 377, icon = "\uD83C\uDF27"),
    THUNDERY_SHOWERS(200, 386, icon = "⛈"),
    LIGHT_SNOW(227, 320, icon = "\uD83C\uDF28"),
    HEAVY_SNOW(230, 329, 332, 338, icon = "❄️"),
    LIGHT_RAIN(266, 293, 296, icon = "\uD83C\uDF26"),
    HEAVY_SHOWERS(299, 305, 356, icon = "\uD83C\uDF27"),

    HEAVY_RAIN(302, 308, 359, icon = "\uD83C\uDF27"),

    LIGHT_SNOW_SHOWERS(323, 326, 368, icon = "\uD83C\uDF28"),
    HEAVY_SNOW_SHOWERS(335, 371, 395, icon = "❄️"),

    THUNDERY_HEAVY_RAIN(389, icon = "\uD83C\uDF29"),
    THUNDERY_SNOW_SHOWERS(392, icon = "⛈");
}