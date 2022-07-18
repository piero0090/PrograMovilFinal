package com.example.programovilfinal.ui.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.programovilfinal.R
import com.example.programovilfinal.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject
import org.w3c.dom.Text

class RegistroposFragment : Fragment() {
    val db= Firebase.firestore

    //private lateinit var binding: ActivityMainBinding
    private lateinit var btnScan : Button
    private lateinit var txtRegistroPos : TextView
    private lateinit var qrScanIntegrator: IntentIntegrator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registropos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnScan = view.findViewById(R.id.btnScanner)
        btnScan.setOnClickListener{
            innitScanner()
        }
        txtRegistroPos = view.findViewById(R.id.txtID_Posicion)
    }

    private fun innitScanner(){
        qrScanIntegrator = IntentIntegrator.forSupportFragment(this)
        qrScanIntegrator.setPrompt("Escanea el código QR para Registrar tu Posición - PARKUL")
        qrScanIntegrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result!=null){
            if(result.contents == null){
                Toast.makeText(activity, "OPERACIÓN CANCELADA", Toast.LENGTH_LONG).show()
            }else{
                txtRegistroPos.text = result.contents
                db.collection("Estacionamientos").
                document(txtRegistroPos.text.toString()).update("Estado",false)
                Toast.makeText(activity, "POSICIÓN REGISTRADA", Toast.LENGTH_LONG).show()
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}