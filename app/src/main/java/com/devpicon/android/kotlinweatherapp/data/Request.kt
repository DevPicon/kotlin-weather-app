package com.devpicon.android.kotlinweatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by Armando on 26/03/2016.
 */
class Request(val url: String){
    fun run(){
        val forecastJson = URL(url).readText()
        Log.d(javaClass.simpleName,  forecastJson)
    }
}