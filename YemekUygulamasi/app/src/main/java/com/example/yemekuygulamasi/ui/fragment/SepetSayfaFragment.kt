package com.example.yemekuygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.data.entity.SepetYemekler
import com.example.yemekuygulamasi.databinding.FragmentSepetSayfaBinding
import com.example.yemekuygulamasi.ui.adapter.SepetAdapter
import com.example.yemekuygulamasi.ui.viewmodel.SepetSayfaFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetSayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentSepetSayfaBinding
    private lateinit var viewModel:SepetSayfaFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet_sayfa, container, false)

        tasarim.sepetSayfaToolbarBaslik = "SEPET"

       viewModel.sepetYemeklerListesi.observe(viewLifecycleOwner){
           val adapteriki = SepetAdapter(requireContext(),it,viewModel)

           tasarim.sepetAdapter = adapteriki
       }


        val bundle: SepetSayfaFragmentArgs by navArgs()
        val sepeteGelenYemekler = bundle.sepetYemekler
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {//bunun içinde viewmodel kodlarını bağlamış olduk
        super.onCreate(savedInstanceState)
        val tempViewModel:SepetSayfaFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun buttonSiparisOnayla(sepet_yemek_id:Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        viewModel.onayla(sepet_yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)


    }


}