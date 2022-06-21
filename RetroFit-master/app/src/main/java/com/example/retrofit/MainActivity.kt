package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.retrofit.model.User
import com.example.retrofit.service.IServicio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        var datos: List<User>

        val lstList = findViewById<ListView>(R.id.lstList)
        var adaptador: ArrayAdapter<User>

        val service = retrofit.create<IServicio>(IServicio::class.java)
        service.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                datos = response.body()!!
                adaptador = ArrayAdapter(this@MainActivity,
                    android.R.layout.simple_list_item_1,datos)
                lstList.adapter = adaptador

            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("RetrofitError",t.message!!)
            }

        })

    }



}