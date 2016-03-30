package com.devpicon.android.kotlinweatherapp.ui

import android.app.Application
import com.devpicon.android.kotlinweatherapp.ui.utils.DelegatesExt

/**
 * Created by Armando on 3/29/2016.
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}