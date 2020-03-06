package com.irfanirawansukirman.cleanarchmono.di

import com.irfanirawansukirman.data.common.coroutine.CoroutineContextProvider
import org.koin.dsl.module

val appModule = module {
    single { CoroutineContextProvider() }
}