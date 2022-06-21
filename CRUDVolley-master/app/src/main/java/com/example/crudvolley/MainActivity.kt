package com.example.crudvolley

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var queue: RequestQueue
    var num=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        queue = Volley.newRequestQueue(this)
        btnGuardar.setOnClickListener{
            Insertar()
        }

        refreshApp()


    }

    private fun refreshApp(){
        swiperefresh.setOnRefreshListener{
            num++
            texto.text = num.toString()
            swiperefresh.isRefreshing = false
        }
    }

    fun Insertar(){
        val datos = JSONObject()
        datos.put("nombre",edtNombre.text.toString())
        datos.put("direccion",edtDir.text.toString())
        datos.put("rutaid_ruta",1)
        datos.put("empresa",edtEmpresa.text.toString())




        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST,
            "http://10.0.2.2:3000/api/insertar",
            datos,
            { response ->
                Log.e("VOLLEYRESPONSE", response.toString())
            },
            { error ->
                Log.e("VOLLEYRESPONSE", error.message!!)
            }
        )
        queue.add(jsonObjectRequest)
    }

}