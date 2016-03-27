package com.devpicon.android.kotlinweatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.devpicon.android.kotlinweatherapp.domain.model.ForecastList

/**
 * Created by Armando on 3/23/2016.
 */
class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}