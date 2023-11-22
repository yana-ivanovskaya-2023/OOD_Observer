package com.example.ood_observer.domain

@JvmInline
value class Degrees(val value: Int)

@JvmInline
value class Humidity(val percent: Int)

@JvmInline
value class Pressure(val hpa: Int)

@JvmInline
value class Precipitation(val mm: Int)