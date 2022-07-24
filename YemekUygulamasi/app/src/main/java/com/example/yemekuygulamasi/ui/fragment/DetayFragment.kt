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
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.databinding.FragmentDetayBinding
import com.example.yemekuygulamasi.ui.viewmodel.DetayFragmentViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {


    private lateinit var tasarim:FragmentDetayBinding
    private lateinit var viewModel:DetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)
        tasarim.detayFragment = this
        tasarim.detaySayfaToolbarBaslik = "YEMEK DETAYI"


        tasarim.imageButtonArttir.setOnClickListener {
            arttir()
        }
        tasarim.imageButtonAzalt.setOnClickListener {

            azalt()
        }


        val bundle:DetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemekler

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(tasarim.imageViewDetayYemekResim)

        tasarim.yemekNesnesi = gelenYemek




        return tasarim.root
    }

    var adet:Int = 0

    fun azalt() {
        adet--
        val textView = tasarim.textViewDetayAdet
        textView.text = "$adet"
    }

    fun arttir() {
        adet++
        val textView = tasarim.textViewDetayAdet
        textView.text = "$adet"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSepeteEkleTikla(
        sepet_yemek_id: String,
        yemek_resim_adi:String,
        yemek_adi: String,
        yemek_fiyat: String,
        yemek_siparis_adet: String,
        kullanici_adi:String
    ){ viewModel.ekle(sepet_yemek_id, yemek_resim_adi, yemek_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi) }


}


