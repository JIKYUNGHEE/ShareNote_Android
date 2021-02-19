package com.snc.sharenote.ui.main.ui.tradingNotes.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.snc.sharenote.R
import com.snc.sharenote.ui.main.ui.tradingNotes.data.Stock
import kotlinx.android.synthetic.main.layout_trading_note_stock.view.*

class StockViewPager(var stockList: List<Stock>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return stockList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val context= container.context
        //TODO. ViewBinding 으로 변경
        val view = LayoutInflater.from(context).inflate(R.layout.layout_trading_note_stock, container, false)
        val rvTradingNoteStock = view.rv_trading_note_stock
        rvTradingNoteStock.layoutManager = LinearLayoutManager(context)
        rvTradingNoteStock.adapter = StockAdapter(stockList[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}