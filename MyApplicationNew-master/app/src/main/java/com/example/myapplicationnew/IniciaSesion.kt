package com.example.myapplicationnew

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_inicia_sesion.*
import kotlinx.android.synthetic.main.activity_main.*

class IniciaSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicia_sesion)

        /*
        val usuario = intent.getStringExtra("user")
        val password = intent.getStringExtra("password")
        val myText = findViewById<TextView>(R.id.strBienvenido)
        println(usuario+" "+password)
        if (usuario== "hola" && password =="123"){
            myText.setText("Bienvenido@ "+usuario)
        }else{
            myText.setText("ERROR")
        }

         */

        val sharedPreference = getSharedPreferences("login", Context.MODE_PRIVATE)
        val usuario = sharedPreference.getString("usuario","@")
        strBienvenido.text = "Bienvenido, $usuario"

        btnCerrar.setOnClickListener{
            with(sharedPreference.edit()){
                remove("usuario")



                commit()

            }

            finish()
        }




    }
}


