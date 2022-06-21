package com.example.pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.pizza.ElementoAdapter
import com.example.pizza.model.Socio

class MainActivity : AppCompatActivity() {
    lateinit var lstLista: ListView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//custom layout

        val lstLista = findViewById<ListView>(R.id.lstLista)
        val datos = listOf(
            Socio("PEPPERONI ESPECIAL", R.drawable.pes,"$110"),
            Socio("MEXICANA", R.drawable.mex,"$100"),
            Socio("CARNES FRÍAS", R.drawable.cf,"$100"),
            Socio("CUATRO QUESOS", R.drawable.queso,"$70"),
            Socio("VEGGIE", R.drawable.vgp,"$200"),


            )

        val adaptador = ElementoAdapter(this@MainActivity,
            R.layout.layout_socio, datos)


        lstLista.adapter = adaptador

        lstLista.setOnItemClickListener{ parent,view,position,id->
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("Nombre",datos[position].nombre)



            startActivity(intent)

        }
    }
}