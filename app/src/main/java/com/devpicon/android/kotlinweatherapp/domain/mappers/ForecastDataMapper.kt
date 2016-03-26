package com.devpicon.android.kotlinweatherapp.domain.mappers

import com.devpicon.android.kotlinweatherapp.data.Forecast
import com.devpicon.android.kotlinweatherapp.domain.model.Forecast as ModelForecast
import com.devpicon.android.kotlinweatherapp.data.ForecastResult
import com.devpicon.android.kotlinweatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*

/**
 * Created by Reapro on 26/03/2016.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}