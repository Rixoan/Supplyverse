package com.example.test2.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.EXTRA_ITEM
import com.example.test2.UI.Item_DetailActivity
import com.example.test2.Models.ItemDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.recomend_item.view.*


class ItemAdapter(var list : ArrayList<ItemDataModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recomend_item,
                parent,
                false
            )
        )    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position) //mengambil data dari list



        if(holder is ItemHolder){
            holder.itemname.text = item.itemname
            holder.itemprice.text = "${item.itemprice}"
            holder.suppliername = item.supplier
            holder.gmbr.setImageResource(item.gmbr)
        }    }

    override fun getItemCount(): Int {
        return (list.size)
    }
    class ItemHolder(view: View) : RecyclerView.ViewHolder(view){
        var itemname = view.tv_item_name
        var itemprice = view.tv_item_price
        var suppliername : String = ""
        var gmbr = view.iv_item_logo
        init {



            view.card_view_item.setOnClickListener { v :View ->
                val position = adapterPosition
                //Toast.makeText(itemView.context,"You click on item ${itemname.text} + ${itemprice.text}",Toast.LENGTH_SHORT).show()
                //var price = itemprice.text.toString()
                //var detail = ItemDataModel(itemname.text.toString(),price.toFloat())

                var intent = Intent(itemView.context, Item_DetailActivity::class.java)
                var intent_item = ItemDataModel(itemname.text.toString(),itemprice.text.toString().toFloat(),suppliername)
                //intent.putExtra(EXTRA_NAMA_ITEM,itemname.text)
                //intent.putExtra(EXTRA_HARGA,itemprice.text)
                //intent.putExtra(EXTRA_NAMA_SUPPLIER,suppliername)
                intent.putExtra(EXTRA_ITEM,intent_item)



                itemView.context.startActivity(intent)




            }
        }

    }
}