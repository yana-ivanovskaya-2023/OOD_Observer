package com.example.ood_observer.data.base.raw

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class RawApi(
    private val client: OkHttpClient
) : IRawApi {

    override suspend fun get(path: String): Response? =
        withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url(path)
                .build()

            try {
                val response = client.newCall(request).execute()
                response
            } catch (ex1: CancellationException) {
                throw ex1
            } catch (ex: IOException) {
                null
            }
        }

}