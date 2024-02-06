package com.draccoapp.movieapp.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.draccoapp.movieapp.di.listModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = applicationContext
        startKoin{
            androidContext(this@MovieAppApplication)
            modules(listModules)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: Context? = null
            private set
    }

}