package com.devpicon.android.kotlinweatherapp.domain.model

/**
 * Created by Reapro on 26/03/2016.
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)