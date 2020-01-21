package com.irfanirawansukirman.data.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irfanirawansukirman.abstraction.base.Loading
import com.irfanirawansukirman.abstraction.base.UiState
import com.irfanirawansukirman.data.common.coroutine.CoroutineContextProvider
import com.irfanirawansukirman.data.common.ext.launch
import com.irfanirawansukirman.data.common.utils.Connectivity
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseVM<T : Any, E> : ViewModel(), KoinComponent {

    protected val coroutineContext: CoroutineContextProvider by inject()

    private val connectivity: Connectivity by inject()

    protected val _uiState = MutableLiveData<UiState<T>>()
    val uiState: LiveData<UiState<T>>
        get() = _uiState

    protected val _uiEffects = MutableLiveData<E>()
    val uiEffects: LiveData<E>
        get() = _uiEffects

    protected fun executeUseCase(action: suspend () -> Unit, noInternetAction: () -> Unit) {
        _uiState.value = Loading()
        if (connectivity.isNetworkAvailable()) {
            launch { action() }
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCase(action: suspend () -> Unit) {
        _uiState.value = Loading()
        launch { action() }
    }

}