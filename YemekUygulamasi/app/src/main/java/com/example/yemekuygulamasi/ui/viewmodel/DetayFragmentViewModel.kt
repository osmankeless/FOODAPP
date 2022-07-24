package com.example.yemekuygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.yemekuygulamasi.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var yrepo:YemeklerDaoRepository) : ViewModel() {


    fun ekle(
        sepet_yemek_id: String,
        yemek_resim_adi:String,
        yemek_adi: String,
        yemek_fiyat: String,
        yemek_siparis_adet: String,
        kullanici_adi:String

    ){ yrepo.sepeteEkle( sepet_yemek_id, yemek_resim_adi, yemek_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }
}