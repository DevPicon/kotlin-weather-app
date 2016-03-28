package com.devpicon.android.kotlinweatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.devpicon.android.kotlinweatherapp.R
import com.devpicon.android.kotlinweatherapp.domain.commands.RequestForecastCommand
import com.devpicon.android.kotlinweatherapp.domain.model.Forecast
import com.devpicon.android.kotlinweatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        async() {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result, object: ForecastListAdapter.OnItemClickListener{
                    override fun invoke(forecast: Forecast){
                        toast(forecast.date)
                    }
                })
                longToast("Request performed")
            }
        }
    }

}
