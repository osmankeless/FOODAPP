package com.example.yemekuygulamasi.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.databinding.FragmentAnasayfaBinding
import com.example.yemekuygulamasi.ui.adapter.YemeklerAdapter
import com.example.yemekuygulamasi.ui.viewmodel.AnasayfaFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

       tasarim.anasayfaFragment = this

       viewModel .yemeklerListesi.observe(viewLifecycleOwner){
           val adapter = YemeklerAdapter(requireContext(),it,viewModel)

           tasarim.yemeklerAdapter = adapter
       }



        return tasarim.root
    }

    fun fabTikla(v:View){ //event handle oluyor

        Navigation.findNavController(v).navigate(R.id.sepeteGecis)


    }






}