package com.example.test2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test2.Adapters.HistoriAdapter
import com.example.test2.EXTRA_SUPPLIER
import com.example.test2.Models.HistoriDataModel
import com.example.test2.Models.SupplierDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.activity_cart_detail.*
import java.util.*


class Cart_DetailActivity : AppCompatActivity() {

    var intent_supplier : SupplierDataModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_detail)
        intent_supplier =intent.getParcelableExtra<SupplierDataModel>(EXTRA_SUPPLIER)

        var listbarang = ""
        var listharga = ""
        var total = 0f

        for (i in intent_supplier!!.itemlist) {
            listbarang += i.itemname + "\n"
            listharga += "RP. "+ i.itemprice.toString() + "\n"
            total += i.itemprice
        }
        tv_cart_detail_item.text = listbarang
        tv_cart_detail_harga.text = listharga
        tv_cart_detail_total.text = total.toString()

        button_checkout.setOnClickListener {
            if (rb_kredit.isChecked) {
                Toast.makeText(
                    this@Cart_DetailActivity, "Kamu berhasil melakukan pembayaran dengan kredit ",
                    Toast.LENGTH_SHORT
                ).show()
                historilist.add(
                    HistoriDataModel(intent_supplier!!,Calendar.getInstance().time.toString(),
                        HistoriAdapter.VIEW_TYPE_SELESAI)
                )

            }
            removefromcart()
            finish()
        }

    }

    fun removefromcart(){
        var index = 0
        for(i in cart){
            if(i.nama == intent_supplier?.nama){
                cart.removeAt(index)
                break

            }
            index++
        }
    }


}
