package com.devocean.spot

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class SpotApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
        setDayMode()
    }

    private fun initTimber() {
       if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun setDayMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}