package com.example.programovilfinal.ui.Fragments;

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DialogRetiroFragmento : DialogFragment() {
    val db= Firebase.firestore
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("¿Desearias retirar el auto de la posicion?")
            .setPositiveButton("SI") {dialog,id->
                db.collection("Estacionamientos").
                document("S6qBxvmntosX7AZw5NiB").update(
                    "Estado",true)
                val toast = Toast.makeText(activity,"Auto retirado", Toast.LENGTH_SHORT)
                toast.show()
            }
            .setNegativeButton("NO"){ _, _ -> }
            .create()
    companion object {
        const val TAG = "ParkULConfirmacion"
    }
}
