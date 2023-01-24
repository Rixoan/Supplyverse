package com.example.test2.UI

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.test2.ACTION_DOWNLOAD
import com.example.test2.EXTRA_FINISH
import com.example.test2.EXTRA_PROGRESS
import com.example.test2.Models.ItemDataModel
import com.example.test2.Models.SupplierDataModel
import com.example.test2.R
import com.example.test2.Services.DownloadService
import kotlinx.android.synthetic.main.activity_add_item.*

class Add_ItemActivity : AppCompatActivity() {

    private val DownloadReciver1 = object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            var progress = p1?.getIntExtra(EXTRA_PROGRESS,0)
            var selesai = p1?.getBooleanExtra(EXTRA_FINISH,true)


            pb_addItem_upload.progress = progress ?: 0
            if(selesai!!){
                imgItem.setImageBitmap(img)
                Toast.makeText(this@Add_ItemActivity,"Selesai Upload",Toast.LENGTH_SHORT).show()
                pb_addItem_upload.visibility = View.INVISIBLE
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        tv_namaitem.doOnTextChanged { text, start, before, count ->
            var namalenght = tv_namaitem.text.toString().length
            var harga = tv_harga.text.toString().length
            enableAddButton(namalenght, harga)
        }
        tv_harga.doOnTextChanged { text, start, before, count ->
            var namalenght = tv_namaitem.text.toString().length
            var harga = tv_harga.text.toString().length
            enableAddButton(namalenght, harga)
        }

        addImg.setOnClickListener {
            pb_addItem_upload.visibility = View.VISIBLE


            var addimage_service = Intent(this, DownloadService::class.java)
            DownloadService.enqueuework(this,addimage_service)


        }
        var filterdownload = IntentFilter(ACTION_DOWNLOAD)
        registerReceiver(DownloadReciver1,filterdownload)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(DownloadReciver1)
    }

    fun enableAddButton(namalenght: Int, harga: Int) {
        if(namalenght >0 && harga>0){
            bt_add.isEnabled = true
        }
        else
        {
            bt_add.isEnabled = false
        }
    }



    fun add_Item(view: View) {
        var user = loginuser
        var nama = tv_namaitem.text.toString()
        var harga = (tv_harga.text.toString()).toFloat()
        var tmpsupplier = SupplierDataModel(user!!.username)

        for(i in supplierlist){
            if(tmpsupplier.nama == i.nama){
                i.itemlist.add(ItemDataModel(nama,harga,i.nama))
                Toast.makeText(this,"Berhasil menambah item",Toast.LENGTH_SHORT).show()
                var intent = Intent()
                setResult(RESULT_OK,intent)
                finish()
                return
            }
        }
        tmpsupplier.itemlist.add(ItemDataModel(nama,harga,tmpsupplier.nama))
        supplierlist.add(tmpsupplier)
        Toast.makeText(this,"Berhasil menambah item",Toast.LENGTH_SHORT).show()
        var intent = Intent()
        setResult(RESULT_OK,intent)
        finish()

    }
}