package com.example.programovilfinal.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.programovilfinal.GestUsers
import com.example.programovilfinal.R

class EditarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_editar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val edtAntPass = view.findViewById<EditText>(R.id.edtPassAntigEdit)
        val edtNewPass = view.findViewById<EditText>(R.id.edtNewPassEdit)
        val edtNewMatricula = view.findViewById<EditText>(R.id.edtMatriculaEdit)
        val edtNewPhone = view.findViewById<EditText>(R.id.edtPhoneEdit)
        val btnUpdate= view.findViewById<Button>(R.id.btnSaveEdit)



        btnUpdate.setOnClickListener {
            GestUsers.getInstance().ActualizarUsers(edtNewPass.text.toString(),
                edtNewMatricula.text.toString(),edtNewPhone.text.toString().toInt())

        }
    }

}