package com.example.programovilfinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.programovilfinal.R
import com.example.programovilfinal.Usuarios
import com.example.programovilfinal.models.Posiciones

class ListadoPosicionesAdapter(private val mListaPosiciones : List<Posiciones>):
    RecyclerView.Adapter<ListadoPosicionesAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPisos : TextView
        val tviPosicion : Button

        init {
            tviPisos = view.findViewById(R.id.tviPisos)
            tviPosicion= view.findViewById(R.id.tviPosicion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_estacionamiento, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posiciones = mListaPosiciones [position]
        holder.tviPisos.text = "Piso " + posiciones.piso.toString()
        holder.tviPosicion.text = posiciones.numero.toString()
    }

    override fun getItemCount(): Int {
        // Devolver el nro de items a mostrar
        return mListaPosiciones.size
    }
}