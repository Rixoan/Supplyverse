package com.example.test2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.Adapters.CartAdapter
import com.example.test2.R
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        var rcview_cart = findViewById<RecyclerView>(R.id.recycler_view_cart)
        recycler_view_cart.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            adapter = CartAdapter()
        }



    }
    override fun onResume() {
        super.onResume()
        recycler_view_cart.adapter?.notifyDataSetChanged() // saat activitas di resume , rc_view akan mengupdate tampilan.
//        recycler_view_cart.apply {
//            layoutManager = LinearLayoutManager(this@CartActivity)
//            adapter = CartAdapter()
//        }
    }



}