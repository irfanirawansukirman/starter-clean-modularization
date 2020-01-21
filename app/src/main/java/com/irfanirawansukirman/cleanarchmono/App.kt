package com.irfanirawansukirman.cleanarchmono

import android.app.Application
import com.irfanirawansukirman.cleanarchmono.di.appModule
import com.irfanirawansukirman.cleanarchmono.di.presentationModule
import com.irfanirawansukirman.data.di.networkModule
import com.irfanirawansukirman.data.di.repositoryModule
import com.irfanirawansukirman.domain.di.interactionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@App)
            if (BuildConfig.DEBUG) androidLogger(Level.DEBUG)
            modules(appModules + domainModule + dataModule)
        }
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}

val appModules = listOf(presentationModule, appModule)
val domainModule = listOf(interactionModule)
val dataModule = listOf(networkModule, repositoryModule)