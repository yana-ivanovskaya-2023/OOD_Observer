package com.example.ood_observer.di

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(applicationContext)
        AppDI.init(applicationContext)
    }

}