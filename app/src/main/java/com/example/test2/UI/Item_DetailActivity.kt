package com.example.test2.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.test2.EXTRA_ITEM
import com.example.test2.Models.ItemDataModel
import com.example.test2.Models.SupplierDataModel
import com.example.test2.R
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_item_detail.*

class Item_DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        //membuat corousel view
        val imgList = intArrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
        )

        val imagesListener = ImageListener { index:Int, imageView: ImageView ->
            imageView.setImageResource(imgList[index])
        }

        //mengambil intent dengan parceable
        var intent_item = intent.getParcelableExtra<ItemDataModel>(EXTRA_ITEM)

        var namadetail = intent_item?.itemname
        item_detail_nama.text = namadetail
        var harga = intent_item?.itemprice
        item_detail_harga.text = "RP " + harga
        var namasupplier = intent_item?.supplier
        item_detail_supplier.text = namasupplier

        for(i in supplierlist){
            if(intent_item?.supplier == i.nama){
                iv_storeLogo.setImageResource(i.gmbr)
            }
        }

        //memasukkan image ke corousel view
        cvContainer.pageCount = imgList.size
        cvContainer.setImageListener(imagesListener)


        tmbh_keranjang.setOnClickListener {
            if(loginuser!=null){
                for(i in cart){
                    if(i.nama == namasupplier){
                        i.itemlist.add(ItemDataModel(namadetail!!,harga!!.toFloat(),namasupplier!!))
                        Toast.makeText(this,"Berhasil ditambah ke cart",Toast.LENGTH_SHORT).show()

                        return@setOnClickListener
                    }

                }
                var tmp_cart = SupplierDataModel(namasupplier!!,"",ArrayList<ItemDataModel>())
                tmp_cart.itemlist.add(ItemDataModel(namadetail!!,harga!!.toFloat(),namasupplier!!))
                cart.add(tmp_cart)

                Toast.makeText(this,"Berhasil ditambah ke cart",Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }


    }


}
}