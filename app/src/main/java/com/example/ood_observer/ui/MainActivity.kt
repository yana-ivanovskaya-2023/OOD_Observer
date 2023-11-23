package com.example.ood_observer.ui

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.ood_observer.databinding.ActivityMainBinding
import com.example.ood_observer.di.WeatherViewModelProvider
import com.example.ood_observer.presentation.WeatherViewData
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
            binding.render(it)
        }.launchIn(lifecycleScope)
    }

    private fun ActivityMainBinding.render(state: WeatherViewData) {
        temperature.text = state.temperature
        temperatureAsFeel.text = state.temperatureAsFeel
        weatherDescription.text = state.localizedDescription
        location.text = state.location
        uvIndexValue.text = state.uvIndex
        humidityValue.text = state.humidity
        pressureValue.text = state.pressure
        precipitationValue.text = state.precipitation
        windValue.text = state.wind
        observationDate.text = state.localObservationDateTime
        weatherIcon.setImageResource(state.weatherIcon.drawableRes)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}