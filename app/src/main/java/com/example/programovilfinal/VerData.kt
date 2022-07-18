package com.example.programovilfinal

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.programovilfinal.ui.Fragments.PosicionesFragment

class VerData: AppCompatActivity() {

    private val fragmentPosiciones = PosicionesFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pisos)
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvSecciones, fragmentPosiciones)
        ft.commit()
    }
}

