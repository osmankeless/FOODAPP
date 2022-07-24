package com.example.yemekuygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yemekuygulamasi.data.entity.*
import com.example.yemekuygulamasi.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository(var ydao:YemeklerDao) {

    var yemeklerListesi:MutableLiveData<List<Yemekler>>

    var sepetYemeklerListesi:MutableLiveData<List<SepetYemekler>>
    init {
        yemeklerListesi = MutableLiveData()
    }
    fun yemekleriGetir(): MutableLiveData<List<Yemekler>>{
        return yemeklerListesi
    }

    init {

        sepetYemeklerListesi = MutableLiveData()
    }
    fun sepetYemekleriGetir(): MutableLiveData<List<SepetYemekler>>{
        return  sepetYemeklerListesi
    }

    fun siparisOnayla(sepet_yemek_id:Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        Log.e("Siparis Onaylandı","$yemek_adi-$yemek_fiyat-$yemek_siparis_adet")

    }
    fun sepeteEkle(
        sepet_yemek_id: String,
        yemek_resim_adi:String,
        yemek_adi: String,
        yemek_fiyat: String,
        yemek_siparis_adet: String,
        kullanici_adi:String

    ){
        ydao.sepeteEklee(yemek_adi,yemek_resim_adi ,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                val basari = response.body().success
                val mesaj = response.body().message
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }
        })
    }

    fun yemekSil(sepet_yemek_id: Int){
        ydao.sepettenSil(sepet_yemek_id, kullanici_adi = "osman_kls").enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                val basari = response.body().success
                val mesaj = response.body().message
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })
    }

    fun tumYemekleriGetir(){
       ydao.tumYemekler().enqueue(object:Callback<YemeklerCevap> {
           override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
               val liste = response.body().yemekler
               yemeklerListesi.value = liste
           }

           override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
       } )
       }


    fun tumSepettekiYemekleriGetir(){
        ydao.tumSepettekiYemekler().enqueue(object:Callback<SepetYemeklerCevap>{
            override fun onResponse(call: Call<SepetYemeklerCevap>?, response: Response<SepetYemeklerCevap>) {
                val sepetListe = response.body().sepetYemekler
                sepetYemeklerListesi.value = sepetListe
            }

            override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {}
        })
    }

}