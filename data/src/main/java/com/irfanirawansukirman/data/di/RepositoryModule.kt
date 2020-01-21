package com.irfanirawansukirman.data.di

import com.irfanirawansukirman.data.common.utils.Connectivity
import com.irfanirawansukirman.data.common.utils.ConnectivityImpl
import com.irfanirawansukirman.data.repository.MoviesRepositoryImpl
import com.irfanirawansukirman.domain.repository.MoviesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<MoviesRepository> { MoviesRepositoryImpl(get()) }
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}