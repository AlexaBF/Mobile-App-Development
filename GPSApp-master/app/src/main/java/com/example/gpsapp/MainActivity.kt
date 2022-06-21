package com.example.gpsapp

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity(), LocationListener {

    lateinit var locationManager: LocationManager
    lateinit var txtLocation: TextView
    lateinit var mapa : GoogleMap

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationManager = getSystemService(Context.LOCATION_SERVICE)
        as LocationManager

        txtLocation = findViewById(R.id.txt_Location)
        checkPermissions(this)

        //lo unico que interesa en el contenedor es saber cuando termino de cargar
        var mapFragment = supportFragmentManager.findFragmentById(R.id.map)
                as SupportMapFragment

        mapFragment.getMapAsync{ googleMap ->
            mapa = googleMap
            mapa.isMyLocationEnabled = true

            val location:LatLng = LatLng(-34.0,151.0)
            mapa.addMarker(MarkerOptions().position(location))

        }



    }

    override fun onLocationChanged(p0: Location) {
        txtLocation.text= "latitud: ${p0.latitude}\nLongitud: ${p0.longitude}"

    }


    private fun checkPermissions(context: Activity){

        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED){
            //si el permiso no se concedió, explicar al usuario porque se ocupa
            if(ActivityCompat.shouldShowRequestPermissionRationale(context,Manifest.permission.ACCESS_FINE_LOCATION)){
                val builder = AlertDialog.Builder(context)
                builder.setMessage("El acceso a la ubicación se requiere por...")
                        .setTitle("Permiso de Ubicación requerido")
                builder.setPositiveButton("OK"){ dialog, id ->
                    ActivityCompat.requestPermissions(context,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 45)
                }

                val dialog = builder.create()
                dialog.show()

            }else{
                //si ono necesita mostrar una explicacion al usuario
                ActivityCompat.requestPermissions(context,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 45)

            }

        }else{
            //1. Proveedor: GPS
            //2. Tiempo de actualización: en milisegundos(10000 = 10 segundos)
            //3. Distancia en metros: 5m
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    1000, 1f, this)

        }

    }


    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            45->{
                if(grantResults[0] != PackageManager.PERMISSION_DENIED){
                    //¿Qué hacer? Cerrar la aplicación? volver a preguntar?
                }else{
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                            1000, 1f, this)
                }
            }

        }





    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        //super.onStatusChanged(provider, status, extras)
    }
}