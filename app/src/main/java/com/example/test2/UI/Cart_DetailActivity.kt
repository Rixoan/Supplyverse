package com.example.test2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.EXTRA_SUPPLIER
import com.example.test2.Models.SupplierDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.activity_cart_detail.*


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


    }
}
