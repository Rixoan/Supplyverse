package com.example.test2.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.UI.Cart_DetailActivity
import com.example.test2.EXTRA_SUPPLIER
import com.example.test2.Models.SupplierDataModel
import com.example.test2.R
import com.example.test2.UI.cart
import kotlinx.android.synthetic.main.cart_list.view.*

class CartAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var holder = CartHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cart_list,
                parent,
                false
            )
        )
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var supplier = cart.get(position)
        if(holder is CartHolder){
            holder.suppliername.text = supplier.nama
        }
    }

    override fun getItemCount(): Int {
        return  cart.size
    }

    class CartHolder (view:View):RecyclerView.ViewHolder(view){
        var suppliername = view.tv_cart_supplier_name

        init {
            view.card_view_cart.setOnClickListener { v: View ->
                val position = adapterPosition
                val tmpsupplier = cart[position]
                val intent_supplier = SupplierDataModel(tmpsupplier.nama,tmpsupplier.tempat,tmpsupplier.itemlist,tmpsupplier.gmbr)
                var intent = Intent(itemView.context, Cart_DetailActivity::class.java)
                intent.putExtra(EXTRA_SUPPLIER,intent_supplier)

                itemView.context.startActivity(intent)
                //Toast.makeText(itemView.context,"You click on supplier_ ${suppliername.text} ",
                //    Toast.LENGTH_SHORT).show()



            }
        }


    }
}