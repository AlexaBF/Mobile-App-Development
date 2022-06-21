package com.example.pizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizza.model.Detalle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val datos = listOf(
            Detalle("La combinación perfecta entre Pepperoni y Champiñones, con un gran sabor y horneado al momento. "
                , R.drawable.pes,"$110","PEPPERONI ESPECIAL"),

            Detalle("La pizza con los sabores auténticos de nuestro país. Chorizo, carne molida, jalapeño, cebolla.",
                R.drawable.mex,"$100","MEXICANA"),

            Detalle("La pizza para los amantes de la carne. Salami, pepperoni, jamón, finas hierbas. ",
                R.drawable.cf,"$100","CARNES FRÍAS"),

            Detalle("La pizza pensada en los amantes del queso. Queso mozzarella, queso crema, queso cheddar, queso parmesano. ",
                R.drawable.queso,"$70","CUATRO QUESOS"),

            Detalle("¡Sólo vegetales! Nuestra opción sin carne. Pimiento, champiñones, aceitunas, cebolla. ",
                R.drawable.vgp,"$200","VEGGIE"),


            )


        val txtNombre = intent.getStringExtra("Nombre")


        when(txtNombre){
            datos[0].Nombre ->{
                txtCosto.setText("Costo: "+ datos[0].precio)
                txtNombreP.setText(datos[0].Nombre)
                txtDescripcion.setText(datos[0].Ingredientes)
                imgP.setImageResource(datos[0].logo)
            }

            datos[1].Nombre ->{
                txtCosto.setText("Costo: "+ datos[1].precio)
                txtNombreP.setText(datos[1].Nombre)
                txtDescripcion.setText(datos[1].Ingredientes)
                imgP.setImageResource(datos[1].logo)
            }
            datos[2].Nombre ->{
                txtCosto.setText("Costo: "+ datos[2].precio)
                txtNombreP.setText(datos[2].Nombre)
                txtDescripcion.setText(datos[2].Ingredientes)
                imgP.setImageResource(datos[2].logo)
            }
            datos[3].Nombre ->{
                txtCosto.setText("Costo: "+ datos[3].precio)
                txtNombreP.setText(datos[3].Nombre)
                txtDescripcion.setText(datos[3].Ingredientes)
                imgP.setImageResource(datos[3].logo)
            }
            datos[4].Nombre ->{
                txtCosto.setText("Costo: "+ datos[4].precio)
                txtNombreP.setText(datos[4].Nombre)
                txtDescripcion.setText(datos[4].Ingredientes)
                imgP.setImageResource(datos[4].logo)
            }
        }



    }
}