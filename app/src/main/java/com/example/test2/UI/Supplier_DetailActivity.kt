package com.example.test2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.Adapters.ItemAdapter
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


        recycler_view_terlaris.apply {
            layoutManager = LinearLayoutManager(this@Supplier_DetailActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = ItemAdapter(supplierdetail.itemlist)
        }
        recycler_view_supplier_itemlist.apply {
            layoutManager = GridLayoutManager(this@Supplier_DetailActivity,2)
            adapter = ItemAdapter(supplierdetail.itemlist)
        }


    }
}