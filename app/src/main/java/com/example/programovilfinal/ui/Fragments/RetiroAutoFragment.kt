package com.example.programovilfinal.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.programovilfinal.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RetiroAutoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RetiroAutoFragment : Fragment() {
    private lateinit var btnRetiro : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retiro_auto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRetiro = view.findViewById(R.id.btnDgRetiro)
        btnRetiro.setOnClickListener{MostrarDialogo()}
    }

    private fun MostrarDialogo(){
        DialogRetiroFragment().show(
            childFragmentManager, DialogRetiroFragment.TAG)
    }

}