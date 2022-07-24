package com.example.yemekuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemekuygulamasi.data.entity.SepetYemekler
import com.example.yemekuygulamasi.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetSayfaFragmentViewModel @Inject constructor(var yrepo:YemeklerDaoRepository) : ViewModel() {

    var sepetYemeklerListesi = MutableLiveData<List<SepetYemekler>>()

    init {
        sepettekiYemekleriYukle()
        sepetYemeklerListesi = yrepo.sepetYemekleriGetir()
    }

    fun onayla(sepet_yemek_id:Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        yrepo.siparisOnayla(sepet_yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    }
    fun sil(sepet_yemek_id: Int){
        yrepo.yemekSil(sepet_yemek_id)
    }
    fun sepettekiYemekleriYukle(){
        yrepo.tumSepettekiYemekleriGetir()
    }
}