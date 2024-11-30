package com.example.mypocket

import android.app.Application
import com.example.mypocket.di.myPocketModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyPocketApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyPocketApplication)
            modules(myPocketModules)
        }
    }
}