package com.example.test2.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.EXTRA_SUPPLIER
import com.example.test2.R
import com.example.test2.UI.Supplier_DetailActivity
import com.example.test2.UI.supplierlist
import kotlinx.android.synthetic.main.supplier_list.view.*

class SupplierAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return supplierholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.supplier_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val supplier = supplierlist.get(position)

        if(holder is supplierholder){
            holder.suppliername.text = supplier.nama
            holder.gmbr.setImageResource(supplier.gmbr)
        }
    }

    override fun getItemCount(): Int {
        return supplierlist.size
    }

    class supplierholder(view:View):RecyclerView.ViewHolder(view){
        var suppliername = view.tv_supplier_name
        var gmbr = view.iv_supplier_logo

        init {
            view.card_view_supplier.setOnClickListener{v:View ->
                val position = adapterPosition

                //Toast.makeText(itemView.context,"You click on supplier_ ${position} ",
                //    Toast.LENGTH_SHORT).show()

                var intent = Intent(itemView.context, Supplier_DetailActivity::class.java)
                var intent_supplier = supplierlist[position]

                //intent.putExtra(EXTRA_INDEX_SUPPLIER,position)
                intent.putExtra(EXTRA_SUPPLIER,intent_supplier)


                itemView.context.startActivity(intent)




            }
        }


    }
}