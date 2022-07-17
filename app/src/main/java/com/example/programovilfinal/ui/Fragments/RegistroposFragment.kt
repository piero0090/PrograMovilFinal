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
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroposFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistroposFragment : Fragment() {

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
        btnScan.setOnClickListener{InnitScanner()}
        txtRegistroPos = view.findViewById(R.id.txtID_Posicion)
    }

    private fun InnitScanner(){
        qrScanIntegrator = IntentIntegrator.forSupportFragment(this)
        qrScanIntegrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result!=null){
            if(result.contents == null){
                Toast.makeText(activity, "pruebita", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(activity, "POSICIÓN REGISTRADA", Toast.LENGTH_LONG).show()
                txtRegistroPos.text = result.contents
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistroposFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistroposFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}