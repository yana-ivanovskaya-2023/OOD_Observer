package com.example.ood_observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.ood_observer.di.WeatherViewModelProvider
import com.example.ood_observer.presentation.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel by viewModels<WeatherViewModel> {
        WeatherViewModelProvider()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel
    }

}