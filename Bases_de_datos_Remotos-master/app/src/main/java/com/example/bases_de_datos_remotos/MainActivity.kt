package com.example.bases_de_datos_remotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //volley tiene dos clases principales
        //requestQueue, Request
        var queue = Volley.newRequestQueue(this@MainActivity)

        val lstLista = findViewById<ListView>(R.id.lstLISTA)

        val url:String = getString(R.string.URL)
        val lista = mutableListOf<String>()
        //val url = "https://jsonplaceholder.typicode.com/users"

        val listener = Response.Listener<JSONArray>{ response ->
            //Log.e("RESPONSE", response.toString())
            for (i in 0 until response.length()) {
                lista.add(
                    response.getJSONObject(i).getString("name") +
                            "\n" + response.getJSONObject(i).getString("email") +
                            "\n" + response.getJSONObject(i).getJSONObject("address")
                        .getString("street")
                )

            }

            val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista)
            lstLista.adapter = adaptador




        }

        val error = Response.ErrorListener { error ->
            Log.e("ERROR", error.message!!)
        }

        val peticion = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            listener,
            error
        )

        queue.add(peticion)

    }
}