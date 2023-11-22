package com.example.ood_observer.data.base

import android.content.Context
import android.net.ConnectivityManager


class NetworkCheckerApiDecorator(
    context: Context,
    private val api: IJsonApi
) : IJsonApi {

    private val mConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager

    override suspend fun <T> get(resultClass: Class<T>, path: String): ApiResult<T> {
        if (mConnectivityManager.activeNetwork == null) {
            return ApiResult.Error.NoInternetConnection
        }
        return api.get(resultClass, path)
    }

}