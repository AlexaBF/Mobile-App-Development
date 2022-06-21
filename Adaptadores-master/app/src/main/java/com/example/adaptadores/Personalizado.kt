package com.example.adaptadores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.adaptadores.model.Socio

class Personalizado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalizado)
        //custom layout

        val lstSocios = findViewById<ListView>(R.id.lstSocios)
        val datos = listOf(Socio("BAMX", R.drawable.bamx,"calle 1"),
            Socio("Alimento", R.drawable.alimentos,"calle 2"),
            Socio("Feliz", R.drawable.feliz,"calle 3"))

        val adaptador = ElementoAdapter(this@Personalizado,
        R.layout.layout_socio, datos)


        lstSocios.adapter = adaptador

        lstSocios.setOnItemClickListener{ parent,view,position,id->
            val intent =Intent(this@Personalizado, MainActivity::class.java)
            intent.putExtra("Nombre",datos[position].nombre)
            startActivity(intent)
        }

    }
}