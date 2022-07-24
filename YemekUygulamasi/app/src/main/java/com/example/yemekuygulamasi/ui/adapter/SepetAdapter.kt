package com.example.yemekuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.yemekuygulamasi.R
import com.example.yemekuygulamasi.data.entity.SepetYemekler
import com.example.yemekuygulamasi.databinding.SepetSayfaCardBinding
import com.example.yemekuygulamasi.ui.viewmodel.SepetSayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context, var sepetYemekListesi:List<SepetYemekler>,var viewModel:SepetSayfaFragmentViewModel) : RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: SepetSayfaCardBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: SepetSayfaCardBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:SepetSayfaCardBinding = DataBindingUtil.inflate(layoutInflater,R.layout.sepet_sayfa_card, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val sepetYemek = sepetYemekListesi.get(position)
        val t = holder.tasarim
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepetYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(t.imageViewSepetYemek)
        t.sepetYemekNesnesi = sepetYemek


        t.imageViewSilResim.setOnClickListener {

            Snackbar.make(it,"${sepetYemek.yemek_adi} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(sepetYemek.sepet_yemek_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return sepetYemekListesi.size
    }
}