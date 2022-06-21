package com.example.menulateral

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerlayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val imgMenu = findViewById<ImageView>(R.id.imgmenu)
        val navView = findViewById<NavigationView>(R.id.navigationView)

        var header = navView.getHeaderView(0)
        val textU = header.findViewById<TextView>(R.id.textView3)
        val textR = header.findViewById<TextView>(R.id.textView2)

        imgMenu.setOnClickListener{
            drawerlayout.openDrawer(GravityCompat.START)
        }

        navView.itemIconTintList = null

        textU.text="USUARIOOOOO"
        textR.text="ROOOOOL"

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mnuRegisRecole->{
                    
                    true
                }


                else ->false
            }
        }



    }
}