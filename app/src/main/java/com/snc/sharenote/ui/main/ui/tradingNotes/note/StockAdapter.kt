package com.snc.sharenote.ui.main.ui.tradingNotes.note

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.ui.main.ui.tradingNotes.data.Stock
import com.snc.sharenote.ui.main.utils.htmlToSpanned

class StockAdapter(var stock: Stock) : RecyclerView.Adapter<StockViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        return StockViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return stock.initStockTitleValue().size
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stockTitle = stock.initStockTitleValue()[position]
        var contentHtml: String = String.format(stockTitle.htmlFormat, stockTitle.content)
        holder.content.text = contentHtml.htmlToSpanned()
    }
}