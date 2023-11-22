package com.example.ood_observer.data.base.raw

import okhttp3.Response
import okhttp3.ResponseBody

interface IRawApi {
    suspend fun get(path: String): Response?
}