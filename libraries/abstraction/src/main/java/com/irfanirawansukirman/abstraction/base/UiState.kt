package com.irfanirawansukirman.abstraction.base

sealed class UiState<out T : Any>
class Success<out T : Any>(val data: T) : UiState<T>()
class Error<out T : Any>(val error: Throwable) : UiState<T>()
class Loading<out T : Any> : UiState<T>()
class NoInternet<T : Any> : UiState<T>()