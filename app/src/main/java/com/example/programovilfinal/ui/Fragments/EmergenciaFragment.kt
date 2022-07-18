package com.example.programovilfinal.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.programovilfinal.R


class EmergenciaFragment() : Fragment() {
    private lateinit var btnDialogo : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_emergencia, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDialogo = view.findViewById(R.id.btnDialogo)
        btnDialogo.setOnClickListener{MostrarDialogo()}
    }

    private fun MostrarDialogo(){
        DialogEmergenciaFragment().show(
            childFragmentManager, DialogEmergenciaFragment.TAG)
    }


}