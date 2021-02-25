package com.snc.sharenote.ui.main.ui.tradingNotes.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.snc.sharenote.databinding.LayoutTradingNoteStockBinding
import com.snc.sharenote.ui.main.ui.tradingNotes.data.Stock

class StockViewPager(var stockList: List<Stock>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return stockList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val context= container.context
        val binding = LayoutTradingNoteStockBinding.inflate(LayoutInflater.from(context))
        val rvTradingNoteStock = binding.rvTradingNoteStock
        rvTradingNoteStock.layoutManager = LinearLayoutManager(context)
        rvTradingNoteStock.adapter = StockAdapter(stockList[position])

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}