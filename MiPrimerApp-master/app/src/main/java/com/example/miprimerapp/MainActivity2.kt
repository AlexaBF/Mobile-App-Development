package com.example.miprimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val usario = intent.getStringExtra("usuario")
        val password = intent.getStringExtra("password")

        println(usario + " " + password)

    }
}