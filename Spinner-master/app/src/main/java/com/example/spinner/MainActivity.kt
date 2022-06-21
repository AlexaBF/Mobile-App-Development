package com.example.spinner

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var DE = "";
    var HACIA = "";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnConvertir.setOnClickListener(this)




        // access the items of the list
        val languages = resources.getStringArray(R.array.monedas)



        // access the spinner
        val spinnerDE = findViewById<Spinner>(R.id.spn_de)
        if (spinnerDE != null) {

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinnerDE.adapter = adapter

            spinnerDE.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()

                    DE = languages[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        val spinnerHACIA = findViewById<Spinner>(R.id.spn_hacia)
        if (spinnerHACIA != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinnerHACIA.adapter = adapter

            spinnerHACIA.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()

                    HACIA = languages[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    override fun onClick(p0: View?) {
        //

        var dato1=0f
        var dato2=0f
        var resultado=0f;

        when (p0!!.id) {
            R.id.btnConvertir->{
                val msg: String = edtTexto.text.toString()
                if(msg.trim().length<=0){
                    var dato = "Introduzca un valor"
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.ERROR) + " " +
                                "" + dato, Toast.LENGTH_SHORT
                    ).show()
                }
                if(DE == HACIA){
                    resultado = Integer.parseInt(edtTexto.text.toString()).toFloat();
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.RES) + " " +
                                "" + resultado, Toast.LENGTH_SHORT
                    ).show()
                }
//---------------------------------------------------------------------------------------
                if(DE == "EUR"  ){
                    if(HACIA == "USD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 1.18f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "MXN"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 23.58f
                        resultado = dato1*dato2/1

                    }
                    else if(HACIA == "AUD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 1.60f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "CAD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 1.50f
                        resultado = dato1*dato2/1

                    }



                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.RES) + " " +
                                "" + resultado, Toast.LENGTH_SHORT
                    ).show()
                }


//---------------------------------------------------------------------------------------
                if(DE == "USD"  ){
                    if(HACIA == "EUR"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.85f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "MXN"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 19.95f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "AUD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 1.36f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "CAD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 1.27f
                        resultado = dato1*dato2/1

                    }



                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.RES) + " " +
                                "" + resultado, Toast.LENGTH_SHORT
                    ).show()
                }

//---------------------------------------------------------------------------------------
                if(DE == "MXN"  ){
                    if(HACIA == "EUR"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.042f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "USD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.050f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "AUD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.068f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "CAD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.064f
                        resultado = dato1*dato2/1

                    }



                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.RES) + " " +
                                "" + resultado, Toast.LENGTH_SHORT
                    ).show()
                }

//---------------------------------------------------------------------------------------
                if(DE == "AUD"  ){
                    if(HACIA == "EUR"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.62f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "USD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.74f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "MXN"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 14.70f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "CAD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.93f
                        resultado = dato1*dato2/1

                    }



                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.RES) + " " +
                                "" + resultado, Toast.LENGTH_SHORT
                    ).show()
                }
//---------------------------------------------------------------------------------------
                if(DE == "CAD"  ){
                    if(HACIA == "EUR"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.67f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "USD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 0.79f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "MXN"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 15.72f
                        resultado = dato1*dato2/1

                    }else if(HACIA == "AUD"){
                        dato1 = Integer.parseInt(edtTexto.text.toString()).toFloat();
                        dato2 = 1.07f
                        resultado = dato1*dato2/1

                    }



                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.RES) + " " +
                                "" + resultado, Toast.LENGTH_SHORT
                    ).show()
                }


            }



        }


    }
}








