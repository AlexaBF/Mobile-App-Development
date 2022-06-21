package tec.mx.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //nombre
        //modo en que se crea y compartir
        //si el nombre de archivo hace referencia a uno que ya existe,
        //lo abre y no lo crea

        val sharedPreference = getSharedPreferences("archivo", Context.MODE_PRIVATE)

        with(sharedPreference.edit()){
            putString("cadena","valor de la cadena")
            putInt("edad",24)
            commit()
        }

        val cadena = sharedPreference.getString("cadena","@")
        if(cadena == "@"){
            //no iniciaste sesio debo mostrarte login
        }else{
            //muestra pantalla inicial porque realizaste login
        }
    }
}