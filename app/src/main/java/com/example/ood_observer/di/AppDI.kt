package com.example.ood_observer.di

import android.content.Context
import com.example.ood_observer.data.WeatherDataMapper
import com.example.ood_observer.data.WeatherGateway
import com.example.ood_observer.data.base.JsonApi
import com.example.ood_observer.data.base.NetworkCheckerApiDecorator
import com.example.ood_observer.data.base.raw.LoggerRawApiDecorator
import com.example.ood_observer.data.base.raw.RawApi
import com.example.ood_observer.domain.WeatherDataObservable
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient

object AppDI {

    val weatherDataObservable by lazy {
        WeatherDataObservable(
            weatherGateway = WeatherGateway(api),
            coroutineScope = CoroutineScope(SupervisorJob()),
            mapper = WeatherDataMapper()
        )
    }
    private val api by lazy {
        NetworkCheckerApiDecorator(
            mApplicationContext,
            JsonApi(mRawApi, Gson())
        )
    }
    private val mOkHttpClient = OkHttpClient()
    private val mRawApi by lazy { LoggerRawApiDecorator(RawApi(mOkHttpClient)) }

    private lateinit var mApplicationContext: Context

    fun init(context: Context) {
        mApplicationContext = context
    }

}