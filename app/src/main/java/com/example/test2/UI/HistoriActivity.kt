package com.example.test2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.Adapters.ViewPagerAdapter
import com.example.test2.R
import kotlinx.android.synthetic.main.activity_histori.*

class HistoriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_histori)
        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HistoriBlmBayarFragment(),"Belum Bayar")
        adapter.addFragment(HistoriSdhBayarFragment(),"Sudah Bayar")
        adapter.addFragment(HistoriSelesaiFragment(),"Selesai")
        viewpager_histori.adapter = adapter
        tabLayout.setupWithViewPager(viewpager_histori)
    }
}