package com.devpicon.android.kotlinweatherapp.domain.model

/**
 * Created by Reapro on 26/03/2016.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast:List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)