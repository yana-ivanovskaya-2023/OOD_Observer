package com.example.ood_observer.domain

import com.example.ood_observer.data.IWeatherGateway
import com.example.ood_observer.data.WeatherDataMapper
import com.example.ood_observer.data.base.ApiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class WeatherDataObservable(
    private val weatherGateway: IWeatherGateway,
    private val coroutineScope: CoroutineScope,
    private val mapper: WeatherDataMapper
) : IWeatherDataObservable {

    private val mObservers = mutableListOf<IWeatherDataObserver>()

    private var mJob: Job? = null
    private var mPrevData: WeatherData? = null

    override fun register(observer: IWeatherDataObserver) {
        mObservers.add(observer)

        if (mJob == null) {
            startThrottling()
        }
    }

    override fun unregister(observer: IWeatherDataObserver) {
        mObservers.remove(observer)

        if (mObservers.isEmpty()) {
            cancelThrottling()
        }
    }

    private fun startThrottling() {
        cancelThrottling()
        mJob = coroutineScope.launch {
            while (mJob?.isActive == true) {
                when (val result = weatherGateway.getWeatherData()) {
                    is ApiResult.Success -> {
                        val newData = mapper.map(result.data)
                        if (newData != mPrevData) {
                            mPrevData = newData
                            mObservers.forEach { it.update(newData) }
                        }
                    }

                    is ApiResult.Error -> Unit
                }
                delay(THROTTLING_DELAY)
            }
        }
    }

    private fun cancelThrottling() {
        mJob?.cancel()
        mJob = null
    }

    companion object {
        private const val THROTTLING_DELAY = 60 * 1000L // 1 min
    }

}