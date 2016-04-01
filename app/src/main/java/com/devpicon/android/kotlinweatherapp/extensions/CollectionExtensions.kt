package com.devpicon.android.kotlinweatherapp.extensions

/**
 * Created by Reapro on 01/04/2016.
 */
fun <K, V : Any> MutableMap<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()