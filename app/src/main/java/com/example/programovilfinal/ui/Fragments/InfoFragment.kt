package com.example.programovilfinal.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.programovilfinal.R

class InfoFragment : Fragment() {
/*
    private var _binding: FragmentGalleryBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding= FragmentGalleryBinding.inflate(inflater, container,false)
        val root: View=binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }
}