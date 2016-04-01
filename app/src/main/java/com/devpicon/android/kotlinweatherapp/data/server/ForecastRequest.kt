package com.devpicon.android.kotlinweatherapp.data.server

import com.devpicon.android.kotlinweatherapp.data.server.ForecastResult
import com.google.gson.Gson
import java.net.URL
/**
 * Created by Reapro on 26/03/2016.
 */
class ForecastRequest(val zipCode: Long) {
    companion object {
        private val APP_ID = "b7a56bb43570189115cb8b2d98cdde5b"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)

    }
}