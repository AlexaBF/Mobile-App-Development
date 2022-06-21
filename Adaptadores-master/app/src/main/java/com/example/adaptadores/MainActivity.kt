package com.example.adaptadores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var lstLista: ListView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //contenedor
        lstLista = findViewById<ListView>(R.id.lstLista)
        //datos
        var datos = listOf("Elemento 1","Elemento 2","Elemento 3")

        //adaptadores
        //acceder a los datos(leerlos) y  crear el layout de cada elemento
        //1.Contexto(this), 2. layout(diseño) 3. datos
        var adaptador = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1
        , datos)

        lstLista.adapter = adaptador

    }
}