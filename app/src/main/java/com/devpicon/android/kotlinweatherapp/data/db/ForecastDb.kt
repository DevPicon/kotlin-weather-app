package com.devpicon.android.kotlinweatherapp.data.db

import com.devpicon.android.kotlinweatherapp.domain.model.ForecastList
import com.devpicon.android.kotlinweatherapp.extensions.clear
import com.devpicon.android.kotlinweatherapp.extensions.parseList
import com.devpicon.android.kotlinweatherapp.extensions.parseOpt
import com.devpicon.android.kotlinweatherapp.extensions.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import java.util.*


/**
 * Created by Reapro on 01/04/2016.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }
}