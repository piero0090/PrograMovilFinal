package com.example.programovilfinal

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
=======
import android.util.Log
import android.view.Menu
import android.view.MenuItem
>>>>>>> 36550661763086f540a7693a66d3c3285146e256
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.programovilfinal.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var avatars= arrayOf(R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04,
        R.drawable.img05, R.drawable.img06)

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        EstacionamientoProvider.estacionamientoList
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        //Insertar datos en el Menu Header
        val header: View =navView.getHeaderView(0)
        val txtnombre : TextView = header.findViewById(R.id.txtNav)
        val imgAvatar : ImageView = header.findViewById(R.id.imgMenu)
        imgAvatar.setImageResource(avatars[Random.nextInt(0,6)])
        txtnombre.setText(intent.getStringExtra("Usercod"))

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_editar, R.id.nav_retirar, R.id.nav_buscar,R.id.nav_registrar,
                R.id.nav_info, R.id.nav_emergencia
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}