package com.example.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.adaptadores.model.Socio


class ElementoAdapter(val context: Context,
                      val layout: Int,
                      val dataSource: List<Socio>): BaseAdapter() {
    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }




    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getView(position: Int,
                         convertView: View?,
                         parent: ViewGroup?): View {
        val view = inflater.inflate(layout,parent,false)

        //cargar los datos del datasource en el elemento cargado (en la view)
        val imagen = view.findViewById(R.id.imgSocio) as ImageView
        val nombre = view.findViewById(R.id.txtNombreSocio) as TextView
        val direccion = view.findViewById(R.id.txtDirSocio) as TextView


        //Extrae un elemento del datasource
        val elemento = getItem(position) as Socio

        //asignar valores a los controles
        nombre.text = elemento.nombre
        direccion.text = elemento.direccion
        imagen.setImageResource(elemento.logo as Int)


        return view
    }
}