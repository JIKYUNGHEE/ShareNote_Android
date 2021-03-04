package com.snc.sharenote.ui.main.tradingNotes.write

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.R
import com.snc.sharenote.databinding.LayoutTradingNoteStockRowBinding

class StockViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.layout_trading_note_stock_row, parent, false)) {

    private val mBinding: LayoutTradingNoteStockRowBinding = LayoutTradingNoteStockRowBinding.bind(itemView)

    val title: TextView = mBinding.tvStockTitle
    val content: TextView = mBinding.tvStockContent
}
