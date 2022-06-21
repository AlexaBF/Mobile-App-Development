package com.example.activitystack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAbrir = findViewById<Button>(R.id.btnAbrir)
        btnAbrir.setOnClickListener{
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}