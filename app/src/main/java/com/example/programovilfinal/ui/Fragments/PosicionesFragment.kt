package com.example.programovilfinal.ui.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.programovilfinal.Constantes
import com.example.programovilfinal.GestorPosiciones
import com.example.programovilfinal.R
import com.example.programovilfinal.adapter.ListadoPosicionesAdapter
import com.example.programovilfinal.models.Posiciones

class PosicionesFragment : Fragment() {

    //private var fechaBuscar: TextView? =null
    private lateinit var mRviPosiciones: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pisos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviPosiciones = view.findViewById(R.id.rviPosiciones)

        //fechaBuscar = view.findViewById(R.id.txtFecha)
        val gestor = GestorPosiciones()

        val sp = requireActivity().getSharedPreferences(
            Constantes.NOMBRE_SP, Context.MODE_PRIVATE
        )

        val piso = "1"
        //val txtSinData = view.findViewById<TextView>(R.id.txtSinData)

        var lista: List<Posiciones> = mutableListOf()
        lista = gestor.obtenerListaPosicionesRoom(
            requireContext().applicationContext, piso
        )

        if (lista.isNotEmpty()) {
            cargarListaPosiciones(lista)
        } else {
            //txtSinData?.setVisibility(TextView.VISIBLE)
            //añadir toast
        }

    }

    private fun cargarListaPosiciones(lista: List<Posiciones>) {
        val adapter = ListadoPosicionesAdapter(lista)
        mRviPosiciones.adapter = adapter
    }

}