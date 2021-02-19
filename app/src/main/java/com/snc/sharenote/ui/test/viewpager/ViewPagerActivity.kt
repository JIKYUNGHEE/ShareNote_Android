package com.snc.sharenote.ui.test.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.snc.sharenote.R
import com.snc.sharenote.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val binding = ActivityViewPagerBinding.inflate(layoutInflater)
        val viewPager = binding.viewPager
        viewPager.adapter = StockViewPager(arrayListOf("1111", "22222", "3333"), this)
    }
}