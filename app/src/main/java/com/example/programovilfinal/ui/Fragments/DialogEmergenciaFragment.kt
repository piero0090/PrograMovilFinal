package com.example.programovilfinal.ui.Fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogEmergenciaFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("¿Desearías llamar a los servicios de emergencia?")
            .setPositiveButton("SI") { _, _ -> }
            .setNegativeButton("NO"){ _, _ -> }
            .create()

    companion object {
        const val TAG = "ParkULConfirmacion"
    }
}