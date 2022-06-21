package com.example.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //App compact activity, si tiene compatibilidad con versiones pasadas
    //Activity, si es la versión actual
    //En Kotlin no hay extends, ni implements, solo hay:
    //class MainActivity extends AppCompactActivity implements View.OnClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //establecer la vista que va cargar activity
        //es una aplicacion de Android R es la clase (instancia)
        //que guarda el registro de TODOS los recursos  de la
        //aplicacion. los agrupa por categorias
        setContentView(R.layout.activity_main)

        //el bloque básico para los componentes del UI e sla vista
        val logIn = findViewById<Button>(R.id.btnLogIn)
        val forgotPassword = findViewById<Button>(R.id.btnForgot)
        val ususario = findViewById<EditText>(R.id.edtUsuario)
        val password = findViewById<EditText>(R.id.edtPassword)
        //edtPassword

        //3a forma de click
        //Crear un metodo que reciba los click de todas las vistas
        logIn.setOnClickListener(this@MainActivity)
        forgotPassword.setOnClickListener(this@MainActivity)


        /*
        //1a forma de click
        logIn.setOnClickListener{
            println("diste click al log in")
        }
         */


    }

    override fun onClick(p0: View?) {
        //null safety

        when(p0!!.id){
            R.id.btnLogIn->{
                println("Diste click al boton login")
                //Intent recibe = origen, Destino
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                //para pasar valores de un  activity a otro
                //se utiliza el metodo putExtra
                //1. etiqueta(como se va a llamar el valor que envia
                // 2. valor a enviar
                intent.putExtra("usuario", edtUsuario.text.toString())
                intent.putExtra("password", edtPassword.text.toString())

                startActivity(intent)
            }
            R.id.btnForgot->{
                println("Diste click al boton forgot password")
            }

        }

    }

    /*
    //2a forma de click, crea una funcion especifica que ejecutare ala boton
    fun clickAforgot(v: View){
        println("Diste click a forgot")
    }
     */

}