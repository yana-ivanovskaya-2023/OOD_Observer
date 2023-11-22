package com.example.ood_observer.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.ood_observer.databinding.ActivityMainBinding
import com.example.ood_observer.di.WeatherViewModelProvider
import com.example.ood_observer.domain.WeatherData
import com.example.ood_observer.domain.WindDirection.*
import com.example.ood_observer.presentation.WeatherViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    private val mViewModel by viewModels<WeatherViewModel> {
        WeatherViewModelProvider()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mBinding = binding

        mViewModel.state.onEach {
            println("It $it")
            binding.render(it)
        }.launchIn(lifecycleScope)
    }

    @SuppressLint("SetTextI18n")
    private fun ActivityMainBinding.render(state: WeatherData) {
        temperature.text = "${state.temperature.asIs.value} ℃"
        temperatureAsFeel.text = "Ощущается как ${state.temperature.asFeel.value} ℃"
        weatherDescription.text = state.localizedDescription
        location.text = "${state.location.city}, ${state.location.region} ${state.location.country}"
        uvIndexValue.text = when (state.uvIndex) {
            in 0..2 -> "Низкий"
            in 3..5 -> "Умеренный"
            in 6..7 -> "Высокий"
            in 8..10 -> "Очень высокий"
            else -> "Экстремальный"
        }
        humidityValue.text = "${state.humidity.percent} %"
        pressureValue.text = "${state.pressure.hpa} гПа"
        precipitationValue.text = "${state.precipitation.mm} мм"

        windValue.text = "${state.wind.speed} км/ч ${
            when (state.wind.direction) {
                SOUTH -> "на юг"
                NORTH -> "на север"
                WEST -> "на запад"
                EAST -> "на восток"
                NORTH_EAST -> "на северо-восток"
                NORTH_WEST -> "на северо-запад"
                SOUTH_EAST -> "на юго-восток"
                SOUTH_WEST -> "на  юго-запад"
            }
        }"

        weatherIcon.text = state.weatherCode.icon
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}