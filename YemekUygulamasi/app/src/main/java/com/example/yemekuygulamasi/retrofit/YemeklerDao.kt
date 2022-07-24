package com.example.yemekuygulamasi.retrofit

import com.example.yemekuygulamasi.data.entity.CRUDCevap
import com.example.yemekuygulamasi.data.entity.SepetYemeklerCevap
import com.example.yemekuygulamasi.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao {
//http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php

    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>


    @GET("yemekler/sepettekiYemekleriGetir.php")
    fun tumSepettekiYemekler() : Call<SepetYemeklerCevap>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepeteEklee(@Field("yemek_adi") yemek_adi: String,
                    @Field("yemek_resim_adi") yemek_resim_adi: String,
                    @Field("yemek_fiyat") yemek_fiyat: String,
                    @Field("yemek_siparis_adet") yemek_siparis_adet: String,
                    @Field("kullanici_adi") kullanici_adi: String) : Call<CRUDCevap>


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepettenSil(@Field("sepet_yemek_id")sepet_yemek_id : Int,
                    @Field("kullanici_adi")kullanici_adi : String) : Call<CRUDCevap>
}