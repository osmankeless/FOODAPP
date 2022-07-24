package com.example.yemekuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemekuygulamasi.data.entity.Yemekler
import com.example.yemekuygulamasi.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor(var yrepo:YemeklerDaoRepository) : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {

        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()

        }

    fun yemekleriYukle(){
        yrepo.tumYemekleriGetir()
    }

}