package com.example.ood_observer.data.base

interface IJsonApi {
    suspend fun <T> get(
        resultClass: Class<T>,
        path: String
    ): ApiResult<T>
}