package com.example.programovilfinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.programovilfinal.Estacionamiento
import com.example.programovilfinal.R

class EstacionamientoAdapter(private val estacionamientoList:List<Estacionamiento>) : RecyclerView.Adapter<EstacionamientoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstacionamientoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EstacionamientoViewHolder(layoutInflater.inflate(R.layout.item_estacionamiento, parent, false))
    }

    override fun onBindViewHolder(holder: EstacionamientoViewHolder, position: Int) {
        val item=estacionamientoList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = estacionamientoList.size
}