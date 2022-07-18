package com.example.programovilfinal.ui.Fragments;

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogRetiroFragmento : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("¿Desearias retirar el carro de la posicion?")
            .setPositiveButton("SI") { _, _ -> }
            .setNegativeButton("NO"){ _, _ -> }
            .create()
    companion object {
        const val TAG = "ParkULConfirmacion"
    }
}
