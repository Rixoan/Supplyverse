package com.example.test2.Adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.EXTRA_INDEX_HISTORI
import com.example.test2.Models.HistoriDataModel
import com.example.test2.R
import com.example.test2.UI.History_DetailActivity
import kotlinx.android.synthetic.main.histori_list.view.*

class HistoriAdapter(var list : ArrayList<HistoriDataModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val VIEW_TYPE_SELESAI = 1
        const val VIEW_TYPE_SDH_BAYAR = 2
        const val VIEW_TYPE_BLM_BAYAR = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val holder = historiholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.histori_list,
                parent,
                false
            )
        )

        return  holder
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var histori = list.get(position)
        if(holder is historiholder){
            holder.suppliername.text = histori.supplier.nama
            holder.tanggal.text = histori.tanggal
            holder.histori = histori

            if(histori.status == VIEW_TYPE_BLM_BAYAR){
                holder.status.text = "Belum Bayar"
            }
            else if(histori.status == VIEW_TYPE_SELESAI)
            {
                holder.status.text = "Selesai"
                holder.status.setTextColor(Color.GREEN)

            }
            else if(histori.status == VIEW_TYPE_SDH_BAYAR){
                holder.status.text = "Sudah Bayar"
                holder.status.setTextColor(Color.BLUE)
            }


        }

    }

    override fun getItemCount(): Int {
        return (list.size)
    }


    class historiholder(view: View):RecyclerView.ViewHolder(view){
        var suppliername = view.tv_histori_supplier_name
        var tanggal = view.tv_histori_tanggal
        var status = view.tv_histori_status
        var histori : HistoriDataModel?= null

        init {
            view.card_view_histori.setOnClickListener { v: View ->
                val position = adapterPosition
                //Toast.makeText(itemView.context,"You click on supplier_ ${suppliername.text} ",
                //    Toast.LENGTH_SHORT).show()
                var intent = Intent(itemView.context, History_DetailActivity::class.java)
                //intent.putExtra(EXTRA_INDEX_HISTORI, list[position])  // dengan menambahkan parameter tambahan untuk digunakan pada histori holder
                intent.putExtra(EXTRA_INDEX_HISTORI, histori)

                itemView.context.startActivity(intent)


            }
        }

    }

}