package com.example.yemekuygulamasi.data.entity

import com.google.gson.annotations.SerializedName

class CRUDCevap(@SerializedName("success") var success:Int
,
                @SerializedName("message") var message:String)  {
}