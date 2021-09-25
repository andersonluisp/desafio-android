package com.picpay.desafio.android.util

sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null,
    val isLoading: Boolean? = null
) {
    class Success<T>(data: T) : Resource<T>(data, isLoading = false)
    class Loading<T>(data: T? = null) : Resource<T>(data, isLoading = true)
    class Error<T>(throwable: Throwable, data: T? = null) : Resource<T>(data, throwable, isLoading = false)
}