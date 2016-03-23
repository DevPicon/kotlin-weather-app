package com.devpicon.android.kotlinweatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Hello Kotlin!"
        toast(message.text.toString())
    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, message, length).show()
    }
}
