package com.devpicon.android.kotlinweatherapp.domain.mappers

import com.devpicon.android.kotlinweatherapp.data.server.Forecast
import com.devpicon.android.kotlinweatherapp.data.server.ForecastResult
import com.devpicon.android.kotlinweatherapp.domain.model.ForecastList
import com.devpicon.android.kotlinweatherapp.domain.model.Forecast as ModelForecast

/**
 * Created by Reapro on 26/03/2016.
 */
class ForecastDataMapper {
    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country,convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt * 1000, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"

}