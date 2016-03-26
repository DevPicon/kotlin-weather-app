package com.devpicon.android.kotlinweatherapp.domain.commands

/**
 * Created by Reapro on 26/03/2016.
 */
interface Command<T>{
    fun execute(): T
}