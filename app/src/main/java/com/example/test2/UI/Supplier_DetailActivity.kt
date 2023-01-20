package com.example.test2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.EXTRA_INDEX_SUPPLIER
import com.example.test2.EXTRA_SUPPLIER
import com.example.test2.Models.SupplierDataModel
import com.example.test2.R
import kotlinx.android.synthetic.main.activity_supplier_detail.*

class Supplier_DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier_detail)

        var intentextra = intent
        val index = intentextra.getIntExtra(EXTRA_INDEX_SUPPLIER,0)
        //var supplierdetail = supplierlist[index]
        var supplierdetail = intent.getParcelableExtra<SupplierDataModel>(EXTRA_SUPPLIER)

        Nama_Supplier.text = supplierdetail?.nama
        jalan.text = "Jalan : "+ supplierdetail?.tempat
        iv_supplierdetail_logo.setImageResource(supplierdetail!!.gmbr)




    }
}