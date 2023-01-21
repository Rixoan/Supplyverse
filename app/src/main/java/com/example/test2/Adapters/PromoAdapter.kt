package com.example.test2.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R
import com.example.test2.UI.promo
import kotlinx.android.synthetic.main.promo_list.view.*

class PromoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return promoholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.promo_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val promo = promo.get(position)

        if(holder is promoholder){
            holder.tanggal.text = promo.tanggal
            holder.gmbr.setImageResource(promo.gmbr)
        }
    }

    override fun getItemCount(): Int {
        return promo.size
    }
    class  promoholder (view :View) : RecyclerView.ViewHolder(view){
        var tanggal = view.tv_promo_tanggal
        var gmbr = view.imageview_promo
    }
}