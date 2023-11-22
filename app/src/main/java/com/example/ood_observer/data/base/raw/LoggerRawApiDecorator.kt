package com.example.ood_observer.data.base.raw

import com.example.ood_observer.data.base.raw.IRawApi
import okhttp3.Response


class LoggerRawApiDecorator(
    private val rawApi: IRawApi
) : IRawApi {

    override suspend fun get(path: String): Response? {
        val time1 = System.currentTimeMillis()
        val response = rawApi.get(path)
        val time2 = System.currentTimeMillis() - time1
        println("GET: $path\nStatus: ${response?.code}\nTime: $time2 ms\n")
        return response
    }

}