package com.example.test2.UI

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.example.test2.Adapters.HistoriAdapter
import com.example.test2.EXTRA_INDEX_HISTORI
import com.example.test2.Models.HistoriDataModel
import com.example.test2.R
import com.example.test2.STORAGE_PERMISSION_REQUEST_CODE
import kotlinx.android.synthetic.main.activity_history_detail.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.Manifest
import kotlin.math.log

class History_DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_detail)

        var histori_supplier = intent.getParcelableExtra<HistoriDataModel>(EXTRA_INDEX_HISTORI)

        var listbarang =""
        var listharga = ""
        var total = 0f

        for(i in histori_supplier?.supplier!!.itemlist){
            listbarang += i.itemname + "\n"
            listharga += "Rp. "+ i.itemprice.toString() + "\n"
            total += i.itemprice
        }
        tv_histori_detail_item.text = listbarang
        tv_histori_detail_harga.text = listharga
        tv_histori_detail_total.text = total.toString()
        tv_histori_detail_tanggal.text = histori_supplier.tanggal
        tv_histori_detail_supplier.text = histori_supplier.supplier.nama
        if(histori_supplier.status == HistoriAdapter.VIEW_TYPE_BLM_BAYAR){
            tv_histori_detail_status.text = "Belum Bayar"
            tv_histori_detail_status.setTextColor(Color.MAGENTA)
            bt_reorder.isEnabled = false
        }
        else if(histori_supplier.status == HistoriAdapter.VIEW_TYPE_SDH_BAYAR){
            tv_histori_detail_status.text = "Sudah Bayar"
            tv_histori_detail_status.setTextColor(Color.BLUE)
            bt_reorder.isEnabled = false
        }
        else if(histori_supplier.status == HistoriAdapter.VIEW_TYPE_SELESAI){
            tv_histori_detail_status.text = "Selesai"
            tv_histori_detail_status.setTextColor(Color.GREEN)
            bt_reorder.isEnabled = true
        }

    }

}