package com.example.multilenguaje

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast.setOnClickListener{
            //toast
            //1. contexto (componente que lo llama)
            //2. texto que va a mostrar
            //3. duracion(constantes)
            //!!No olvidar el .show()
            Toast.makeText(this@MainActivity,
            edtTexto.text,
            Toast.LENGTH_SHORT).show()
        }

        //3 botones, máximo 2 de un tipo
        //NeutraButton, positivebutton, NegativeButton
        btnAlert.setOnClickListener{
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle(R.string.str_dialog_title).setMessage(edtTexto.text)
                .setPositiveButton(R.string.str_yes){
                        dialog,button ->dialog.dismiss()}

                .setNegativeButton(R.string.str_no){
                        dialog,button ->dialog.dismiss()}


                .setNeutralButton(R.string.str_later){
                        dialog,button ->dialog.dismiss()}
                .show()
        }




        btnConsole.setOnClickListener{
            //log.
            // .e = Error
            // .d = Debug
            // .i = Informativos
            // .w = WTF
            // .v = Verbose
            Log.w("VOLLEY","NO DISPONIBLEEEEEEEE")
        }

    }
}