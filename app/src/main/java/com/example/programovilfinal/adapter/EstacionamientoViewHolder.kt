package com.example.programovilfinal.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.programovilfinal.Estacionamiento
import com.example.programovilfinal.R

class EstacionamientoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val estacionamientoLado = view.findViewById<TextView>(R.id.tvEstacionamientoLado)
    val estacionamientoNivel = view.findViewById<TextView>(R.id.tvEstacionamientoNivel)
    fun render(estacionamientoModel: Estacionamiento){
        estacionamientoLado.text= estacionamientoModel.seccion
        estacionamientoNivel.text= estacionamientoModel.nivel
    }

}