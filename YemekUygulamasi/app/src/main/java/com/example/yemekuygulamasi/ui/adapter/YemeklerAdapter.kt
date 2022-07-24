package com.example.yemekuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.data.entity.Yemekler
import com.example.yemekuygulamasi.databinding.AnasayfaCardBinding
import com.example.yemekuygulamasi.databinding.FragmentAnasayfaBinding
import com.example.yemekuygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.example.yemekuygulamasi.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.yemekuygulamasi.ui.viewmodel.SepetSayfaFragmentViewModel
import com.squareup.picasso.Picasso

class YemeklerAdapter(
    var mContext:Context,
    var yemeklerListesi:List<Yemekler>,
    var viewModel: AnasayfaFragmentViewModel
) : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:AnasayfaCardBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:AnasayfaCardBinding
        init {
            this.tasarim = tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:AnasayfaCardBinding = DataBindingUtil.inflate(layoutInflater,R.layout.anasayfa_card, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(t.imageViewYemekResim)

        t.yemekNesnesi = yemek
        t.cardViewYemekler.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayaGecis(yemekler = yemek)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
       return yemeklerListesi.size
    }


}