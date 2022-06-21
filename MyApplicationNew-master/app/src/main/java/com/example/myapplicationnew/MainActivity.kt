package com.example.myapplicationnew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.CleartextNetworkViolation
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreference = getSharedPreferences("login",Context.MODE_PRIVATE)

        if(sharedPreference.getString("usuario","@") != ""
            && sharedPreference.getString("usuario","@") != "@"){
            //mandar directamente al home
            val intent= Intent(this
            ,IniciaSesion::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        /*
        val logIn = findViewById<Button>(R.id.btnLogIn)
        val cancelar = findViewById<Button>(R.id.btnCancelar)
        val usuario = findViewById<EditText>(R.id.edtUsuario)
        val password = findViewById<EditText>(R.id.edtPassword)

         */
        btnLogIn.setOnClickListener(this@MainActivity)
        btnCancelar.setOnClickListener(this@MainActivity)

    }
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnLogIn->{

                println("Login click")
                val intent = Intent(this@MainActivity, IniciaSesion::class.java)




                if (edtUsuario.text.toString()== "hola" && edtPassword.text.toString() =="123"){

                    with(sharedPreference.edit()){
                        putString("usuario",edtUsuario.text.toString())
                        commit()
                        startActivity(intent)
                    }
                }else{


                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()

                }

                //intent.putExtra("user",edtUsuario.text.toString())

                //intent.putExtra("password",edtPassword.text.toString())
                //startActivity(intent)
            }
            R.id.btnCancelar->{
                println("Cancel click")

                finish()
                System.exit(0)
            }
        }
    }


}