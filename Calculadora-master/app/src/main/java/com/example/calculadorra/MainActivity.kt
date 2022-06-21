package com.example.calculadorra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.EditText




class MainActivity : AppCompatActivity(), View.OnClickListener{
    //lateinit var btnSiete: Button;
    lateinit var txtResutado: TextView;

    var mValueOne = 0f
    var mValueTwo=0f


    //probando cambios en github
    var crunchifyAddition =false
    var mSubtract= false
    var crunchifyMultiplication=false
    var crunchifyDivision= false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //btnSiete = findViewById(R.id.btnSiete)
        txtResutado = findViewById(R.id.txtResultado)

        btnCero.setOnClickListener(this)
        btnUno.setOnClickListener(this)
        btnDos.setOnClickListener(this)
        btnTres.setOnClickListener(this)
        btnCuatro.setOnClickListener(this)
        btnCinco.setOnClickListener(this)
        btnSeis.setOnClickListener(this)
        btnOcho.setOnClickListener(this)
        btnNueve.setOnClickListener(this)
        btnMas.setOnClickListener(this)
        btnMenos.setOnClickListener(this)
        btnMultiplica.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnIgual.setOnClickListener(this)
        btnSiete.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        //txtResultado.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {


        when(p0!!.id){
            //cambio de números
            R.id.btnCero ->{
                txtResutado.text= txtResutado.text.toString() + "0"

            }
            R.id.btnUno ->{
                txtResutado.text= txtResutado.text.toString() + "1"

            }
            R.id.btnDos ->{
                txtResutado.text= txtResutado.text.toString() + "2"

            }
            R.id.btnTres ->{
                txtResutado.text= txtResutado.text.toString() + "3"
            }
            R.id.btnCuatro ->{
                txtResutado.text= txtResutado.text.toString() + "4"
            }
            R.id.btnCinco ->{
                txtResutado.text= txtResutado.text.toString() + "5"
            }
            R.id.btnSeis ->{
                txtResutado.text= txtResutado.text.toString() + "6"
            }
            R.id.btnSiete ->{
                txtResutado.text= txtResutado.text.toString() + "7"
            }
            R.id.btnOcho ->{
                txtResutado.text= txtResutado.text.toString() + "8"
            }
            R.id.btnNueve ->{
                txtResutado.text= txtResutado.text.toString() + "9"
            }
            R.id.btnMas ->{

                if (txtResultado == null) {
                    txtResutado.setText("");
                } else {

                    mValueOne = Integer.parseInt(txtResutado.getText().toString()).toFloat();
                    crunchifyAddition = true;
                    txtResutado.setText(null);

                    /*
                txtResutado.setText("");//borrar barra de resultados

                txtResutado.text= txtResutado.text.toString() + "+"

                 */

                }
            }


            R.id.btnMenos ->{

                mValueOne = Integer.parseInt(txtResutado.getText().toString()).toFloat();
                mSubtract = true;
                txtResutado.setText(null);

                //var variable = Integer.parseInt(txtResutado.getText().toString());
                /*
                txtResutado.setText("");//borrar barra de resultados

                txtResutado.text= txtResutado.text.toString() + "-"

                 */

            }
            R.id.btnMultiplica ->{

                mValueOne = Integer.parseInt(txtResutado.getText().toString()).toFloat();
                crunchifyMultiplication = true;
                txtResutado.setText(null);
                /*

                txtResutado.setText("");//borrar barra de resultados
                txtResutado.text= txtResutado.text.toString() + "*"

                 */


            }
            R.id.btnDivide ->{

                mValueOne = Integer.parseInt(txtResutado.getText().toString()).toFloat()
                crunchifyDivision = true;
                txtResutado.setText(null);

                /*
                txtResutado.setText("");//borrar barra de resultados
                txtResutado.text= txtResutado.text.toString() + "/"

                 */

            }
            R.id.btnIgual ->{
                var res=0f;
                mValueTwo = (txtResutado.getText().toString() + "").toFloat()

                if (crunchifyAddition == true) {
                    res = (mValueOne+mValueTwo)
                    txtResutado.setText(res.toString() +"" )

                    crunchifyAddition = false
                }
                if (mSubtract == true) {
                    res = mValueOne - mValueTwo
                    txtResutado.setText(res.toString() + "")
                    mSubtract = false
                }
                if (crunchifyMultiplication == true) {
                    res=mValueOne * mValueTwo
                    txtResutado.setText(res.toString() + "")
                    crunchifyMultiplication = false
                }
                if (crunchifyDivision == true) {
                    res=mValueOne / mValueTwo
                    txtResutado.setText(res.toString() + "")
                    crunchifyDivision = false
                }




                //txtResutado.text
                //txtResutado.setText("");//borrar barra de resultados
                //txtResutado.text= txtResutado.text.toString() + ""
            }

            R.id.btnClear->{
                txtResutado.setText(null);
            }
        }
    }




}