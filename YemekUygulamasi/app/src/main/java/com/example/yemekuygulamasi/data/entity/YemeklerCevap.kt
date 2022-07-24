package com.example.yemekuygulamasi.data.entity

import com.google.gson.annotations.SerializedName

class YemeklerCevap (

    @SerializedName("yemekler" ) var yemekler : List<Yemekler> ,
    @SerializedName("success"  ) var success  : Int

){
}