package com.devpicon.android.kotlinweatherapp.domain.commands

import com.devpicon.android.kotlinweatherapp.data.ForecastRequest
import com.devpicon.android.kotlinweatherapp.domain.mappers.ForecastDataMapper
import com.devpicon.android.kotlinweatherapp.domain.model.ForecastList

/**
 * Created by Reapro on 26/03/2016.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}